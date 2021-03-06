package twgitter.gitter;

import java.lang.reflect.Type;
import java.util.Collection;
import java.util.List;

import twgitter.TestThread;
import twgitter.get.GetHTTP;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class GetRooms {
	/**
	 * コマンドをcmdに投げて出てきたjsonを取得する
	 *
	 * @return roomの情報のjson
	 * @throws Exception
	 */
	public static String getRooms() throws Exception
	{
		//curl -i -H "Accept: application/json" -H "Authorization: Bearer f942da113703b8fb345a9277945098757265255e" https://api.gitter.im/v1/rooms -k
		/*
		String command = "curl -i -H \"Accept: application/json\" -H \"Authorization: Bearer " + TestThread.allTokens.getGitterToken() + "\" \"https://api.gitter.im/v1/rooms\" -k";
		String[] jsons = Command.execCommand(command);
		*/
		String URI = "https://api.gitter.im/v1/rooms";
		String[][] Header = { {"Accept", "application/json"}, {"Authorization", "Bearer " + TestThread.allTokens.getGitterToken()} };
		List<String> jsons = GetHTTP.AccessHTTPString(URI, Header, "UTF8");
		String json = jsons.get(0);

		//デバッグ
		/*
		for(int i=0;i<jsons.size();i++)
		{
			System.out.println(jsons.get(i));
		}
		*/

		/*
		if(jsons.get(0).equals("HTTP/1.1 200 OK"))
		{
			json = jsons.get(14);
			System.out.println("[Gitter]Successed to read json.");
		}else if(jsons.get(0) == null){
			System.out.println("[Gitter]Error CURL[command: \"curl can't use\"]");
		}else{
			System.out.println("[Gitter]Error CURL[command: \"curl gitter api\"]");
		}
		*/

		return json;
	}

	/**
	 * Roomの情報のjsonをRoomのListに変換する
	 *
	 * @param json Roomの情報のjson(getRooms())
	 * @return Roomの情報のList
	 */
	public static List<Room> jsonToListRooms(String json)
	{
		Gson gson = new Gson();
		Type collectionType = new TypeToken<Collection<Room>>(){}.getType();
		List<Room> roomList = gson.fromJson(json.toString(),collectionType);

		return roomList;
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
		List <Room> rooms = jsonToListRooms(getRooms());
		//ほしかった部屋のID
		String wantRoomID = null;

		for(int i=0;i<rooms.size();i++)
		{
			if(rooms.get(i).getName().equals(wantRoomName))
			{
				wantRoomID = rooms.get(i).getId();
			}
		}
		return wantRoomID;
	}
}
