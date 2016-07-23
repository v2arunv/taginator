import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.ResultSetFuture;
import com.datastax.driver.core.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by flazer on 23/7/2016.
 */
public class InitializeCassandra {

    private Logger logger;
    private Cluster cluster;
    private Session session;

    public InitializeCassandra(Cluster cluster, Session session)
    {
        this.logger = LoggerFactory.getLogger(InitializeCassandra.class);
        this.cluster = cluster;
        this.session = session;
    }

    public boolean createKeyspaces()
    {
        String query = "CREATE KEYSPACE blogs WITH replication"
                + "= {'class':'SimpleStrategy', 'replication_factor':1}";
        session.execute(query);
        logger.debug("Creating Keyspace \"blogs\" on Apache Cassandra");
        String use = "USE blogs";
        session.execute(use);
        logger.debug("Using Keyspace \"blogs\"");
        return true;
    }
}
