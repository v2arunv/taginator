import io.netty.handler.codec.http.HttpResponse;

/**
 * Created by flazer on 24/7/2016.
 */
public interface ResponseCreator {

    public String getHeader();
    public String getContent();
}
