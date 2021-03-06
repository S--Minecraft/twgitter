package twgitter.slack;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import twgitter.TestThread;
import twgitter.get.GetHTTP;
import twgitter.slack.json.HistoryFirst;
import twgitter.slack.json.Message;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class GetChannelHistory {
	private static GetChannels getC = new GetChannels();

	public static String getChannelHistory(String channelName,String lastest,String oldest,int count) throws Exception{
		String channelId = getC.nameToId(channelName);

		String URI = "https://slack.com/api/channels.history?token=" + TestThread.allTokens.getSlackToken() + "&channel=" + channelId + "&lastest=" + lastest + "&oldest=" + oldest + "&count=" + count;
		List<String> json = GetHTTP.AccessHTTPString(URI);

		String jsonString = json.get(0);

		return jsonString;
	}

	public static String getChannelHistory(String channelName) throws Exception{
		String channelId = getC.nameToId(channelName);

		String URI = "https://slack.com/api/channels.history?token=" + TestThread.allTokens.getSlackToken() + "&channel=" + channelId;
		List<String> json = GetHTTP.AccessHTTPString(URI);

		String jsonString = json.get(0);

		return jsonString;
	}

	public static List<Message> jsonToMessage(String json) {
		Gson gson = new Gson();

		char[] jsonChar = json.toCharArray();

		List<Message> messages = new ArrayList<>();

		if(jsonChar[0] == '[')
		{
			Type collectionType = new TypeToken<Collection<HistoryFirst>>(){}.getType();
			List<HistoryFirst> HistoryFirst = gson.fromJson(json.toString(),collectionType);

			for(int i=0;i<HistoryFirst.size();i++)
			{
				messages.addAll(HistoryFirst.get(i).getMessages());
			}

		}else if(jsonChar[0] == '{'){
			HistoryFirst HistoryFirst = gson.fromJson(json.toString(),HistoryFirst.class);

			messages = HistoryFirst.getMessages();

		}else{
			System.out.println("[Slack]Undefind json shape...");
			messages = null;
		}

		return messages;
	}
}
