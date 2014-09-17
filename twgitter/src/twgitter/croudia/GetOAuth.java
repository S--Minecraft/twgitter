package twgitter.croudia;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map.Entry;
import java.util.SortedMap;
import java.util.TreeMap;

import twgitter.croudia.config.Config;
import twgitter.get.Command;

import com.google.gson.Gson;

public class GetOAuth {
	public static void getOAuthCode() throws Exception {
		String urlStr = "http://api.croudia.com/oauth/token";
        String consumerkey = Config.ConsumerKey;
        String consumersecret = Config.ConsumerSecret;

        //Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + "https://api.croudia.com/oauth/authorize?response_type=code&client_id=" + consumerkey);
        Command.execCommand("rundll32.exe url.dll,FileProtocolHandler \"https://api.croudia.com/oauth/authorize?response_type=code&client_id=" + consumerkey + "\"");

        System.out.println("ブラウザのURLからcodeを入力してください");
        System.out.print(">>");
        BufferedReader input = new BufferedReader(new InputStreamReader(
            System.in));
        String code = input.readLine();
        System.out.println("code=" + code);

        SortedMap<String, String> params = new TreeMap<>();
        params.put("grant_type", "authorization_code");
        params.put("client_id", consumerkey);
        params.put("client_secret", consumersecret);
        params.put("code", code);

        String parameter = "";
        for (Entry<String, String> param : params.entrySet()) {
            parameter += param.getKey() + "=" + param.getValue() + "&";
        }

        parameter = parameter.substring(0, parameter.length() - 1);

        URL url = new URL(urlStr + "?" + parameter);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("POST");
        connection.connect();
        BufferedReader reader = new BufferedReader(new InputStreamReader(
                connection.getInputStream()));
        String line;
        String response = "";
        while ((line = reader.readLine()) != null) {
            response += line + "\n";
        }
        reader.close();

        //System.out.println(response);

        Gson gson = new Gson();
        Tokens tokens = gson.fromJson(response.toString(),Tokens.class);

        /*
        System.out.println("AccessToken : " + tokens.getAccess_token());
        System.out.println("TokenType : " + tokens.getToken_type());
        System.out.println("ExpiresIn : " + tokens.getExpires_in());
        System.out.println("RefreshToken : " + tokens.getRefresh_token());
         */

        Config.setAccess_token(tokens.getAccess_token());
        Config.setExpires_in(tokens.getExpires_in());
        Config.setRefresh_token(tokens.getRefresh_token());

	}
}
