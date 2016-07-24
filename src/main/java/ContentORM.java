import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by flazer on 24/7/2016.
 */
public class ContentORM {

    private CassandraAccessor cassandraAccessor;
    private Logger logger;

    public ContentORM(CassandraAccessor cassandraAccessor) {
        this.cassandraAccessor = cassandraAccessor;
        this.logger = LoggerFactory.getLogger(ContentORM.class);
    }

    public void insertContent(ContentModel contentModel) {
        String query = "INSERT INTO "+CassandraValues.keyspaceName+"."+CassandraValues.tableName+"(id, payload, tags, created_at) VALUES"
                +"(" +
                String.valueOf(contentModel.getId()) +",'"
                + contentModel.getPayload() + "',"
                + "{'1':'"+contentModel.getTags().get(0)+"'}"+","
                +"'2011-02-03T04:05+0000');";
        logger.debug(query);
        cassandraAccessor.getSession().execute(query);

    }
}
