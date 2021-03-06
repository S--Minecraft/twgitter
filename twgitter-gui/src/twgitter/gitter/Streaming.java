package twgitter.gitter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLConnection;

import twgitter.TestThread;
import twgitter.gitter.json.ChatFromUser;
import twgitter.gitter.json.ChatString;
import twgitter.gui.Test;

import com.google.gson.Gson;

public class Streaming extends Thread {
	public String roomName;

	public Streaming(String room){
		roomName = room;
		//System.out.println(roomName);
	}

	//public static void gitterStreaming(String roomName) throws Exception {
	public void run() {
		System.out.println("[Gitter]Starting up Gitter...");
		// 引数からURIを生成
		String streamRoomId = "";
		try {
			//System.out.println(roomName);
			streamRoomId = GetRooms.roomNameToId(roomName);
			//System.out.println(streamRoomId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		String URI = "https://stream.gitter.im/v1/rooms/" + streamRoomId + "/chatMessages";
		String[][] Header = { {"Authorization", "Bearer " + TestThread.allTokens.getGitterToken()}, {"Accept", "application/json"} };
		String CharCode = "UTF-8";
		Gson gson = new Gson();

		URI uri =null;
		try {
			uri = new URI(URI);
		} catch (URISyntaxException e1) {
			e1.printStackTrace();
		}

		// URI -> URL -> URLConnection の順で接続インスタンスを取得
		URLConnection connection = null;
		try {
			connection = uri.toURL().openConnection();
		} catch (IOException e) {
			e.printStackTrace();
		}

		//ヘッダ設定
		if(!(Header[0][0].equals("") && Header[0][1].equals("")))
		{
			for(int i=0;i<Header.length;i++)
			{
				connection.setRequestProperty(Header[i][0] ,Header[i][1]);
			}
		}

		// ヘッダ情報を出力
		/*
		Map<String, List<String>> headers = connection.getHeaderFields();
		for (Object key : headers.keySet()) {
			System.out.println("[Misc]HTTP Headers{" + key + ": " + headers.get(key) + "}");
		}
		*/

		// コンテンツを出力
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new InputStreamReader(connection.getInputStream(), CharCode));
		} catch (IOException e) {
			e.printStackTrace();
		}
		String buffer = null;
		try {
			buffer = reader.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("[Gitter]Successed to get HTTP");

		while(null != buffer)
		{
			//System.out.println("G:" + buffer);
			char[] bufferChar = buffer.toCharArray();
			/*
			if(bufferChar[0] == '[')
			{
				Type collectionType = new TypeToken<Collection<ChatString>>(){}.getType();
				List<ChatString> string = gson.fromJson(buffer,collectionType);
				for(int i=0;i<string.size();i++)
				{
					ChatFromUser user = string.get(i).getFromUser();
					System.out.println("[Gitter][" + user.getDisplayName() + "(" + user.getUsername()  + ")]" + string.get(i).getText());
				}
			}else */
			if(bufferChar[0] == '{'){
				ChatString chat = gson.fromJson(buffer.toString(),ChatString.class);
				ChatFromUser user = chat.getFromUser();
				/*if(chat.getText().matches("\\[!\\[.*\\.((png)|(jpg)|(gif)|(jpeg))\\](http\\.*.((png)|(jpg)|(gif)|(jpeg)))\\]"))
				{
					System.out.print("[Gitter]mached");
					String chatText = chat.getText();
					int beforeFileName = chatText.indexOf("\\[!\\[")+1;
					int afterFileName = chatText.indexOf("((png)|(jpg)|(gif)|(jpeg))\\]");
					String FileName = chatText.substring(beforeFileName,afterFileName);

					int beforeUrl = chatText.indexOf("\\(http")+1;
					int afterUrl = chatText.indexOf("\\)\\]\\(");
					String Url = chatText.substring(beforeUrl,afterUrl);

					String Out = "[Gitter][" + user.getDisplayName() + "(" + user.getUsername() + ")]" + "#Image [" + FileName + "(" + Url + ")]";

					System.out.println(Out);
				}else{*/
					System.out.println("[Gitter][" + roomName + "][" + user.getDisplayName() + "(@" + user.getUsername()  + ")]" + chat.getText());
					Test.println("[Gitter][" + roomName + "][" + user.getDisplayName() + "(@" + user.getUsername()  + ")]" + chat.getText());
					//}
			}else if(bufferChar[0] == ' '){
				//System.out.println("[Gitter]No new chats now.");
			}else{
				System.out.println("[Gitter][" + roomName + "]Undefind buffer case...");
			}
		try {
			buffer = reader.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		}
	}

	/*
	public void start(String roomName) {
		run(roomName);
	}
	*/
}
