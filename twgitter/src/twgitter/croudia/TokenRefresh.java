package twgitter.croudia;

import twgitter.TestThread;
import twgitter.get.Command;

import com.google.gson.Gson;

public class TokenRefresh {
	public static void refreshToken() throws Exception {
		//curl -k -F "grant_type=refresh_token" -F "client_id=a22268f222dd11a7f32325f5234445f9a52efa9f62b63f5fb43133defd18fcdf" -F "client_secret=0e32069c074722e3e06df23fa701629bd32f1eff554b2c678630882ea5e1f87c " -F "refresh_token=49277bee70a23cdef7a818a02b01e669ea179bd2566f31c9aa58c69fed4527e2" https://api.croudia.com/oauth/token
		String command = "curl -k -F \"grant_type=refresh_token\" -F \"client_id=" + TestThread.allTokens.getCroudiaConsumerKey() + "\" -F \"client_secret=" + TestThread.allTokens.getCroudiaConsumerSecret() + "\" -F \"refresh_token=" + TestThread.allTokens.getCroudiaRefresh_token() + "\" https://api.croudia.com/oauth/token";
		String[] json = Command.execCommand(command);

		Gson gson = new Gson();

		Tokens tokens = gson.fromJson(json[0].toString(),Tokens.class);

		/*
		System.out.println("AccessToken : " + tokens.getAccess_token());
		System.out.println("TokenType : " + tokens.getToken_type());
		System.out.println("ExpiresIn : " + tokens.getExpires_in());
		System.out.println("RefreshToken : " + tokens.getRefresh_token());
		*/

		TestThread.allTokens.setCroudiaAccess_token(tokens.getAccess_token());
		TestThread.allTokens.setCroudiaToken_type(tokens.getToken_type());
		TestThread.allTokens.setCroudiaExpires_in(tokens.getExpires_in());
		TestThread.allTokens.setCroudiaRefresh_token(tokens.getRefresh_token());

		System.out.println("[Croudia]Successed to refresh the token.");
	}
}