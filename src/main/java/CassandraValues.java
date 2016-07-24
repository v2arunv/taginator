import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by flazer on 24/7/2016.
 */
public class CassandraValues {

    public static final String keyspaceName = "ContentBank";
    public static final String tableName = "content";
    public static AtomicInteger idCounter = new AtomicInteger(1);

}
