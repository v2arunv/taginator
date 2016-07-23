import java.util.ArrayList;

/**
 * Created by flazer on 23/7/2016.
 */
public class ContentModel {

    private String id;
    private String description;
    private ArrayList<String> tags;

    public ContentModel(String id, String description, ArrayList<String> tags)
    {
        this.id = id;
        this.description = description;
        this.tags = tags;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ArrayList<String> getTags() {
        return tags;
    }

    public void setTags(ArrayList<String> tags) {
        this.tags = tags;
    }
}
