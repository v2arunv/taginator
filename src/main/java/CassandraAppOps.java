import com.datastax.driver.core.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by flazer on 23/7/2016.
 */
public class CassandraAppOps {

    private Logger logger;
    private CassandraAccessor cassandraAccessor;
    private Session session;

    public CassandraAppOps(CassandraAccessor cassandraAccessor)
    {
        this.logger = LoggerFactory.getLogger(CassandraAppOps.class);
        this.cassandraAccessor = cassandraAccessor;
        this.session = cassandraAccessor.getSession();

    }

    public boolean createKeyspaces()
    {

        String query = "CREATE KEYSPACE "+CassandraValues.keyspaceName+" WITH replication"
                + "= {'class':'SimpleStrategy', 'replication_factor':1}";
        session.execute(query);
        logger.debug("Creating Keyspace \""+CassandraValues.keyspaceName+"\" on Apache Cassandra");
        String use = "USE "+CassandraValues.keyspaceName;
        session.execute(use);
        logger.debug("Using Keyspace \""+CassandraValues.keyspaceName+"\"");
        return true;
    }

    public boolean createContentTable()
    {
        String query = "CREATE TABLE "+CassandraValues.tableName+" ("
                +"id int PRIMARY KEY,"
                +"payload varchar,"
                +"tags map<text,text>,"
                +"created_at timestamp"
                +");";
        logger.debug("Creating Table with CQL command \""+query+"\"");
        session.execute(query);
        return true;
    }


    public boolean dropKeyspace()
    {
        String query = "DROP KEYSPACE "+CassandraValues.keyspaceName;
        session.execute(query);
        return true;
    }
}
