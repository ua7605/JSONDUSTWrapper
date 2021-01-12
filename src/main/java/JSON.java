import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

/**
 * The JSON class will load the a JSON configuration file in.
 * The JSON file is a DUST configuration file that were the block name is specified and all the channels were an application
 * can send data.
 */
public class JSON {



    public JSON() throws IOException, ParseException
    {

        JSONParser jsonParser = new JSONParser();

        FileReader reader = new FileReader("DUSTconfig.json");

        Object object = jsonParser.parse(reader);

        JSONObject jsonObject = (JSONObject) object;

        String blockname = (String) jsonObject.get("BlockName-of-subscribe-block");


        JSONArray channelarray = (JSONArray) jsonObject.get("list-of-channels");

        DUSTBlockChannels dustBlockChannels = DUSTBlockChannels.getInstance();
        dustBlockChannels.setBlockName(blockname);

        System.out.println(dustBlockChannels.getBlockName());//TODO: A possible error can accur here when the return type is null.

        for (int i= 0; i< channelarray.size();i++)
        {
            JSONObject channelNameobj = (JSONObject) channelarray.get(i);

            String channelName = (String)channelNameobj.get("channelName"+i);
            dustBlockChannels.addChannelName(channelName);
        }

        for (String index: dustBlockChannels.getChannelNameList())
        {
            System.out.println(index);
        }
    }




}
