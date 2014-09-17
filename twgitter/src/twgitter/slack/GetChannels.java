package twgitter.slack;

import java.util.List;

import twgitter.get.Command;
import twgitter.slack.config.Config;

import com.google.gson.Gson;

public class GetChannels {
	/**
	 * コマンドをcmdに投げて出てきたjsonを取得する
	 *
	 * @return roomの情報のjson
	 * @throws Exception
	 */
	public static String getChannel() throws Exception
	{
		//-H "Accept: application/json"
		//curl -i -k -F "token=xoxp-2661652273-2663282232-2663409938-02398e" "https://slack.com/api/channels.list"
		String command = "curl -i -k -F \"token=" + Config.token + "\" \"https://slack.com/api/channels.list\"";
		String[] jsons = Command.execCommand(command);
		String json = "";

		//デバッグ

		for(int i=0;i<jsons.length;i++)
		{
			System.out.println(jsons[i]);
		}


		if(jsons[2].equals("HTTP/1.1 200 OK"))
		{
			json = jsons[18];
			System.out.println("[Slack]Successed to read json.");
		}else if(jsons[0] == null){
			System.out.println("[Slack]Error CURL[command: \"curl can't use\"]");
		}else{
			System.out.println("[Slack]Error CURL[command: \"curl slack api\"]");
		}

		return json;
	}

	/**
	 * Roomの情報のjsonをRoomのListに変換する
	 *
	 * @param json Roomの情報のjson(getRooms())
	 * @return Roomの情報のList
	 */
	public static List<Channel> jsonToListChannel(String json)
	{
		Gson gson = new Gson();
		ChannelFirst channelFirst = gson.fromJson(json.toString(),ChannelFirst.class);
		List<Channel> channelList = channelFirst.getChannels();

		return channelList;
	}

	/**
	 * Roomの名前からIDを取得する
	 *
	 * @param wantRoomName ほしいRoomの名前(例:S--Minecraft/twgitter)
	 * @return RoomのID
	 * @throws Exception
	 */
	public static String roomNameToId(String wantRoomName) throws Exception
	{
		List <Channel> channels = jsonToListChannel(getChannel());
		//ほしかった部屋のID
		String wantRoomID = "";

		for(int i=0;i<channels.size();i++)
		{
			if(channels.get(i).getName().equals(wantRoomName))
			{
				wantRoomID = channels.get(i).getId();
			}
		}
		return wantRoomID;
	}
}