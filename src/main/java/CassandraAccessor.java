import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Session;

/**
 * Created by flazer on 24/7/2016.
 */
public class CassandraAccessor {

    private Cluster cluster;
    private Session session;

    public CassandraAccessor(Cluster cluster, Session session)
    {
        this.cluster = cluster;
        this.session = session;
    }

    public CassandraAccessor()
    {
        this.cluster = Cluster.builder().addContactPoint("192.168.8.2").build();
        this.session = cluster.connect("dev");
    }

    public Cluster getCluster() {
        return cluster;
    }

    public void setCluster(Cluster cluster) {
        this.cluster = cluster;
    }

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }



}
