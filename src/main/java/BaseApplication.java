import io.vertx.core.AbstractVerticle;
import io.vertx.core.http.HttpServer;
import io.vertx.core.http.HttpServerResponse;
import io.vertx.ext.web.Router;


/**
 * Created by flazer on 23/7/2016.
 */
public class BaseApplication extends AbstractVerticle{

    private HttpServer server;
    private CassandraAppOps cassandraAppOps;

    public static void main(String[] args) {

    }

    @Override
    public void start()throws Exception{
        server = vertx.createHttpServer();

        CassandraAccessor cassandraAccessor = new CassandraAccessor();

        cassandraAppOps = new CassandraAppOps(cassandraAccessor);
//        cassandraAppOps.dropKeyspace();
        cassandraAppOps.createKeyspaces();
        cassandraAppOps.createContentTable();


        Router router = Router.router(vertx);
        router.route("/putBasic").handler(routingContext -> {

            HttpServerResponse response = routingContext.response();
            ResponseCreator responseCreator = new PutBasicContent(response);
            response.putHeader("content-type",responseCreator.getHeader());
            response.end(responseCreator.getContent());

        });
        server.requestHandler(router::accept).listen(8080);
    }

    @Override
    public void stop() throws Exception
    {
        cassandraAppOps.dropKeyspace();
    }
}
