package twgitter.slack;

import java.util.List;

import twgitter.TestThread;
import twgitter.get.GetHTTP;
import twgitter.get.GetJsonThenListI;
import twgitter.slack.json.Channel;
import twgitter.slack.json.ChannelFirst;

import com.google.gson.Gson;

public class GetChannels implements GetJsonThenListI{
	/**
	 * jsonを取得する
	 *
	 * @return channelの情報のjson
	 * @throws Exception
	 */
	@Override
	public String getJSONString() throws Exception {
		//-H "Accept: application/json"
		//curl -i -k -F "token=xoxp-2661652273-2663282232-2663409938-02398e" "https://slack.com/api/channels.list"
		//String command = "curl -i -k -F \"token=" + Config.token + "\" \"https://slack.com/api/channels.list\"";
		String URI = "https://slack.com/api/channels.list?token=" + TestThread.allTokens.getSlackToken();
		List<String> jsons = GetHTTP.AccessHTTPString(URI);
		//String[] jsons = Command.execCommand(command);
		String json = jsons.get(0);

		return json;
	}

	/**
	 * Channelの情報のjsonをChannelのListに変換する
	 *
	 * @param json Channelの情報のjson(getChannels())
	 * @return Channelの情報のList
	 */
	@Override
	public List<Channel> jsonToList(String json) {
		Gson gson = new Gson();
		ChannelFirst channelFirst = gson.fromJson(json.toString(),ChannelFirst.class);
		List<Channel> channelList = channelFirst.getChannels();

		return channelList;
	}

	/**
	 * Channelの名前からIDを取得する
	 *
	 * @param wantChannelName ほしいRoomの名前(例:general)
	 * @return ChannelのID
	 * @throws Exception
	 */
	@Override
	public String nameToId(String wantNameOrId) throws Exception {
		List <Channel> channels = jsonToList(getJSONString());
		//ほしかった部屋のID
		String wantRoomID = "";

		for(int i=0;i<channels.size();i++)
		{
			if(channels.get(i).getName().equals(wantNameOrId))
			{
				wantRoomID = channels.get(i).getId();
			}
		}
		return wantRoomID;
	}
}