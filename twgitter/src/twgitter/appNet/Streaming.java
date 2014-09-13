package twgitter.appNet;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import twgitter.appNet.config.Config;
import twgitter.get.GetHTTP;

import com.google.gson.Gson;

public class Streaming {
	//curl -k -H "Authorization: Bearer AQAAAAAAC9R-kjm8uCBwXwDJxXV3_hh5VMzzlFu0bV1vk99FgQVaUq7rPswGRsAeB80yHCAeoeFWmx4oYMWOgmBwbaiH499NEw" -H "X-ADN-Pretty-JSON: 1" "https://api.app.net/posts/stream"

	public static Date streaming(Date lastDate) throws Exception {
		// 引数からURIを生成
		String URI = "https://api.app.net/posts/stream";
		String[][] Header = { {"Authorization", "Bearer " + Config.token}, {"X-ADN-Pretty-JSON", "1"} };
		String CharCode = "UTF-8";
		Gson gson = new Gson();
		List<String> json = new ArrayList<>();
		StringBuilder jsonGettingToString = new StringBuilder();
		Date nowGet = new Date();

		json = GetHTTP.AccessHTTPString(URI,Header,CharCode);

		for(int i=0;i<json.size();i++)
		{
			//System.out.println("A :" + json.get(i));
			jsonGettingToString.append(json.get(i));
		}

		//System.out.println();
		//System.out.println("A :" + jsonGettingToString);

		String jsonString = jsonGettingToString.toString();

		AppNetStream stream = gson.fromJson(jsonString.toString(),AppNetStream.class);

		for(int i=stream.getData().size()-1;i>=0;i--)
		{
			nowGet = stream.getData().get(i).getCreated_atDate();
			if(nowGet.after(lastDate))
			{
				//System.out.println(lastDate);
				//System.out.println(nowGet);

				User user = stream.getData().get(i).getUser();
				String name;
				if(user.getName() == null)
				{
					name = user.getUsername();
				}else{
					name = user.getName();
				}

				if(stream.getData().get(i).getText() != null)
				{
					System.out.println("[App.net][" + name + "(@" + user.getUsername()  + ")]" + stream.getData().get(i).getText());
				}
			}
		}

		Date lastGet = new Date();
		lastGet = stream.getData().get(0).getCreated_atDate();

		return lastGet;
	}

	public static Date appNetDateStringToDate(String dateString) throws ParseException
	{
		Date dateDate = new Date();
		SimpleDateFormat appNetDate = new SimpleDateFormat("yyyy'-'MM'-'dd'T'HH':'mm':'ss'Z'");
		appNetDate.setLenient(false);

		dateDate = appNetDate.parse(dateString);

		return dateDate;
	}
}
