package twgitter.twitter;

import twgitter.TestThread;
import twitter4j.conf.ConfigurationBuilder;

public class GetConfig {
	public static ConfigurationBuilder cb;

	public static void doConfig()
	{
		ConfigurationBuilder configbuild = new ConfigurationBuilder();
		configbuild.setDebugEnabled(/*true*/false)
		.setOAuthConsumerKey(TestThread.allTokens.getTwitterConsumerKey())
		.setOAuthConsumerSecret(TestThread.allTokens.getTwitterConsumerSecret())
		.setOAuthAccessToken(TestThread.allTokens.getTwitterAccessToken())
		.setOAuthAccessTokenSecret(TestThread.allTokens.getTwitterAccessTokenSecret());

		cb = configbuild;
	}
}
