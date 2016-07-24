import io.vertx.core.http.HttpServerResponse;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

/**
 * Created by flazer on 24/7/2016.
 */
public class PutBasicContent implements ResponseCreator {

    private HttpServerResponse response;
    private String jsonResponse;
    private ContentORM contentORM;
    private CassandraAccessor cassandraAccessor;

    public PutBasicContent(HttpServerResponse response) {
        this.response = response;
        this.cassandraAccessor = new CassandraAccessor();
        this.contentORM = new ContentORM(this.cassandraAccessor);
    }

    public PutBasicContent(HttpServerResponse response, CassandraAccessor accessor) {
        this.response = response;
        this.cassandraAccessor = accessor;
        this.contentORM = new ContentORM(this.cassandraAccessor);
    }

    @Override
    public String getHeader() {
        return ("text/plain");
    }

    @Override
    public String getContent() {
        ArrayList<String> tags = new ArrayList<>();
        tags.add("tag1");
        tags.add("tag2");
        ContentModel contentModel = new ContentModel(CassandraValues.idCounter.incrementAndGet(), "This is going to be fun", tags, new Date());
        contentORM.insertContent(contentModel);
        return "success";
    }
}
