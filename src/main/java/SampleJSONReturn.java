import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by flazer on 23/7/2016.
 */
public class SampleJSONReturn {

    private ContentModel contentModel;
    private ObjectMapper mapper;
    private String description;

    public SampleJSONReturn()
    {
        this.description = "Baddest Motherfucker in town";

    }

    public void createContentModel()
    {
        String name = "Varun Vasudevan";
        String tag1 = "Varun";
        String tag2 = "Boss";
        ArrayList<String> tags = new ArrayList<String>(Arrays.asList(tag1,tag2));
        contentModel = new ContentModel(name,description,tags);
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public String toJSON()
    {
        String s = "";
        try {
            s = mapper.writeValueAsString(contentModel);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return s;
    }
}
