import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * The JSON class will load the a JSON configuration file in.
 * The JSON file is a DUST configuration file that were the block name is specified and all the channels were an application
 * can send data.
 */
public class JSONHandeler {



    public JSONHandeler(String Pahtfile_To_DUSTConf) throws IOException, ParseException
    {
    }

    public static void initializeDUSTChannels(String Pahtfile_To_DUSTConf) throws IOException, ParseException
    {
        JSONParser jsonParser = new JSONParser();

        FileReader reader = new FileReader(Pahtfile_To_DUSTConf);

        Object object = jsonParser.parse(reader);

        JSONObject jsonObject = (JSONObject) object;

        String blockname = (String) jsonObject.get("BlockName-of-subscribe-block");

        JSONArray channelarray = (JSONArray) jsonObject.get("list-of-channels");

        DUSTBlockChannels dustBlockChannels = DUSTBlockChannels.getInstance();

        dustBlockChannels.setBlockName(blockname);

        System.out.println(dustBlockChannels.getBlockName());

        if(dustBlockChannels.getBlockName() != null)
        {
            for (int i= 0; i< channelarray.size();i++)
            {
                JSONObject channelNameobj = (JSONObject) channelarray.get(i);

                dustBlockChannels.addChannelName((String)channelNameobj.get("channelName"+i));
                System.out.println(dustBlockChannels.getChannelNameList().get(i));
            }
        }
        //Works fine.
    }
}
