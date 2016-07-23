import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;
import com.datastax.driver.core.Session;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.http.HttpServer;
import io.vertx.core.http.HttpServerResponse;
import io.vertx.ext.web.Router;


import java.util.ArrayList;
import java.util.Arrays;


/**
 * Created by flazer on 23/7/2016.
 */
public class BaseApplication extends AbstractVerticle{

    private HttpServer server;

    public static void main(String[] args) {

    }

    @Override
    public void start()throws Exception{
        server = vertx.createHttpServer();
        Cluster cluster = Cluster.builder().addContactPoint("192.168.8.2").build();
        Session session = cluster.connect("dev");
        InitializeCassandra initializeCassandra = new InitializeCassandra(cluster, session);
        initializeCassandra.createKeyspaces();

        Router router = Router.router(vertx);
        router.route().handler(routingContext -> {

            HttpServerResponse response = routingContext.response();

            response.putHeader("content-type","text/plan");

//            session.execute("INSERT INTO emp (emp_first,emp_last,emp_dept,empid) VALUES ('Varun','Vasudevan','Boss',3)");
//
//            String returnString = "";
//            ResultSet results = session.execute("select * from emp;");
//            for (Row row: results)
//                    returnString=row.getString("emp_first");
//
            response.end("Success");

        });
        server.requestHandler(router::accept).listen(8080);
    }
}
