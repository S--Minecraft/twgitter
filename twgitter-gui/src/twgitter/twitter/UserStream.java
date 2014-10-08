package twgitter.twitter;

import twitter4j.TwitterStream;
import twitter4j.TwitterStreamFactory;
import twitter4j.conf.Configuration;

public class UserStream extends Thread{
	public static Configuration cfg;
	//public static void twitterUserStream() throws TwitterException
	public void run()
	{
		System.out.println("[Twitter]Starting up Twitter...");
		//GetConfig.doConfig();
		//Configuration cfg=GetConfig.cb.build();

		TwitterStream twitterStream = new TwitterStreamFactory(cfg).getInstance();

		MyUserStreamAdapter UserStream = new MyUserStreamAdapter();
		twitterStream.addListener(UserStream);
		twitterStream.user();
	}

	public UserStream(Configuration cfg)
	{
		this.cfg = cfg;
	}
}
