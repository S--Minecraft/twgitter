package twgitter.appNet;

import java.util.ArrayList;
import java.util.List;

import twgitter.appNet.config.Config;
import twgitter.get.GetHTTP;

import com.google.gson.Gson;

public class Streaming {
	//curl -k -H "Authorization: Bearer AQAAAAAAC9R-kjm8uCBwXwDJxXV3_hh5VMzzlFu0bV1vk99FgQVaUq7rPswGRsAeB80yHCAeoeFWmx4oYMWOgmBwbaiH499NEw" -H "X-ADN-Pretty-JSON: 1" "https://api.app.net/posts/stream"

	public static void main(String[] args) throws Exception {
		// 引数からURIを生成
		String URI = "https://api.app.net/posts/stream";
		String[][] Header = { {"Authorization", "Bearer " + Config.token}, {"X-ADN-Pretty-JSON", "1"} };
		String CharCode = "UTF-8";
		Gson gson = new Gson();
		List<String> json = new ArrayList<>();
		StringBuilder jsonGettingToString = new StringBuilder();

		json = GetHTTP.AccessHTTPString(URI,Header,CharCode);

		for(int i=0;i<json.size();i++)
		{
			System.out.println("A :" + json.get(i));
			jsonGettingToString.append(json.get(i));
		}

		System.out.println();
		System.out.println("A :" + jsonGettingToString);
	}
}
