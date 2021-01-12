import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Discription:
 */
public class JSON {



    public JSON() throws IOException, ParseException {

        JSONParser jsonParser = new JSONParser();

        FileReader reader = new FileReader("DUSTconfig.json");

        Object object = jsonParser.parse(reader);

        JSONObject jsonObject = (JSONObject) object;

        String blockname = (String) jsonObject.get("BlockName-of-subscribe-block");


        JSONArray channelarray = (JSONArray) jsonObject.get("list-of-channels");

        for (int i= 0; i< channelarray.size();i++){
            JSONObject channelNameobj = (JSONObject) channelarray.get(i);

            String channelName = (String)channelNameobj.get("channelName"+i);
            System.out.println(channelName);
        }





    }




}
