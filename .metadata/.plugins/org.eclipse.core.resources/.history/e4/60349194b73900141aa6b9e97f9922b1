import java.util.List;

import twgitter.get.GetHTTP;
import twgitter.gitter.ChatString;
import twgitter.gitter.GetRooms;
import twgitter.gitter.config.Config;

import com.google.gson.Gson;

public class Test {
	private static List<String> stream;
	private static List<ChatString> chatString;

	public static void main(String[] args) throws Exception {

	String streamRoomId = GetRooms.roomNameToId("S--Minecraft/twgitter");
	System.out.println(streamRoomId + " _______ " + Config.token);
	String URI = "https://stream.gitter.im/v1/rooms/" + streamRoomId + "/chatMessages";
	String[][] Header = { {"Authorization", "Bearer " + Config.token}, {"Accept", "application/json"} };
	String CharCode = "UTF-8";

	stream = null;


	GetHTTP.AccessHTTP(URI,Header,CharCode);


	Gson gson = new Gson();

	chatString = null;

	for(int i=0;i<stream.size();i++)
	{
		 chatString.add(gson.fromJson(stream.get(i),ChatString.class));
	}

	for(int i=0;i<chatString.size();i++)
	{
		System.out.println("[" + chatString.get(i).getFromUser().getDisplayName() + "(" + chatString.get(i).getFromUser().getUsername()  + ")]" + chatString.get(i).getText());
	}
	}
}