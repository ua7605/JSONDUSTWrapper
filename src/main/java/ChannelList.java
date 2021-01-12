import java.util.ArrayList;

public class ChannelList {


    static ChannelList obj = new ChannelList();

    static ArrayList<String> channelNameList;

    private ChannelList() {
        channelNameList = new ArrayList<>();
    }

    public static ChannelList getInstance()
    {
        return obj;
    }

    public void addChannelName(String channelName)
    {
        channelNameList.add(channelName);
    }

    public ArrayList<String> getChannelNameList() {
        return channelNameList;
    }
}
