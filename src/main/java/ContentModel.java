import java.util.ArrayList;
import java.util.Date;

/**
 * Created by flazer on 23/7/2016.
 */
public class ContentModel {

    private int id;
    private String payload;
    private ArrayList<String> tags;
    private Date created_at;

    public ContentModel(int id, String payload, ArrayList<String> tags, Date created_at)
    {
        this.id = id;
        this.payload = payload;
        this.tags = tags;
        this.created_at = created_at;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPayload() {
        return payload;
    }

    public void setPayload(String payload) {
        this.payload = payload;
    }

    public ArrayList<String> getTags() {
        return tags;
    }

    public void setTags(ArrayList<String> tags) {
        this.tags = tags;
    }
}
