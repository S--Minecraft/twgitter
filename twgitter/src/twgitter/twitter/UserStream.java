package twgitter.twitter;

import twgitter.twitter.config.Config;
import twitter4j.TwitterStream;
import twitter4j.TwitterStreamFactory;
import twitter4j.conf.Configuration;

public class UserStream extends Thread{
	//public static void twitterUserStream() throws TwitterException
	public void run()
	{
		Config.doConfig();
		Configuration cfg=Config.cb.build();

		TwitterStream twitterStream = new TwitterStreamFactory(cfg).getInstance();

		MyUserStreamAdapter UserStream = new MyUserStreamAdapter();
		twitterStream.addListener(UserStream);
		twitterStream.user();
	}
}
