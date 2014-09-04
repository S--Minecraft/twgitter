package twgitter.twitter;

import twgitter.twitter.config.Config;
import twitter4j.TwitterException;
import twitter4j.TwitterStream;
import twitter4j.TwitterStreamFactory;
import twitter4j.conf.Configuration;

public class Sample2 {
	public static void main(String[] args) throws TwitterException
	{
		Config.doConfig();
		Configuration cfg=Config.cb.build();

		TwitterStream twitterStream = new TwitterStreamFactory(cfg).getInstance();

		MyUserStreamAdapter UserStream = new MyUserStreamAdapter();
		twitterStream.addListener(UserStream);
		twitterStream.user();
	}
}
