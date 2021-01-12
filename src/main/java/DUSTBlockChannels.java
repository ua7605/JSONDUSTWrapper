import java.util.ArrayList;

public class DUSTBlockChannels {


    static DUSTBlockChannels obj = new DUSTBlockChannels();
    static String blockName;
    static ArrayList<String> channelNameList;

    private DUSTBlockChannels() {
        channelNameList = new ArrayList<>();
    }

    public static DUSTBlockChannels getInstance()
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

    public void setBlockName(String blockName) {
        DUSTBlockChannels.blockName = blockName;
    }

    public String getBlockName() {
        if (blockName == null){
            System.out.println("The block has not been initialized!");
            return null;
        }else {
            return blockName;
        }
    }
}
