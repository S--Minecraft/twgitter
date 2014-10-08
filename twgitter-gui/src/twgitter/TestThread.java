package twgitter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import twgitter.IRC.Connect;
import twgitter.appNet.StreamGetterA;
import twgitter.config.AllTokens;
import twgitter.config.GeneralConfig;
import twgitter.config.LoadProperties;
import twgitter.croudia.GetOAuth;
import twgitter.croudia.StreamGetterC;
import twgitter.croudia.TokenRefresh;
import twgitter.gitter.Streaming;
import twgitter.slack.HistoryGetter;
import twgitter.twitter.GetConfig;
import twgitter.twitter.Tweet;
import twgitter.twitter.UserStream;
import twitter4j.conf.Configuration;

public class TestThread extends Thread {
	public static AllTokens allTokens;
	public static Configuration twitterCfg;

	public static UserStream twitter;
	public static Tweet twitterTweet;

	/*
	public void run() {
		for(int i = 1; i <= 10; i++) {
			System.out.println(getName() + ":" + i);
			try {
				sleep(180000);
			} catch (InterruptedException e) {
			}
		}
	}*/

	public static void main(String[] args) throws Exception{
		/*
		 * Start All
		 */
		//Load Config
		GeneralConfig generalCfg = LoadProperties.loadGeneralConfig();

		AllTokens tokens = LoadProperties.loadTokenConfig();
		allTokens = tokens;

		//Load Twitter Config
		if(generalCfg.isConnectTwitter())
		{
			GetConfig.doConfig();
			Configuration cfg = GetConfig.cb.build();
			twitterCfg = cfg;
		}

		//Croudia Token Refresh
		if(generalCfg.isConnectCroudia())
		{
			Date tokenExpirationDate = tokens.getCroudiaGetDateDate();
			tokenExpirationDate.setTime(tokenExpirationDate.getTime() + tokens.getCroudiaExpires_in()*1000);

			if(tokenExpirationDate.before(new Date()))
			{
				GetOAuth.getOAuthCode(tokens);
			}else{
				TokenRefresh.refreshToken();
			}
		}

		/*
		 * Make Instance
		 */
		//twitter
		//UserStream twitter = new UserStream();
		if(generalCfg.isConnectTwitter())
		{
			twitter = new UserStream(twitterCfg);
			twitterTweet = new Tweet(twitterCfg);
		}

		//app.net
		StreamGetterA appNet = new StreamGetterA();

		//croudia
		StreamGetterC croudia = new StreamGetterC();

		//gitter
		List<Streaming> gitter = new ArrayList<Streaming>();
		for(int i=0;i<generalCfg.getGitterRooms().size();i++)
		{
			gitter.add(new Streaming(generalCfg.getGitterRooms().get(i)));
		}

		//slack
		List<HistoryGetter> slack = new ArrayList<HistoryGetter>();
		for(int i=0;i<generalCfg.getSlackChannels().size();i++)
		{
			slack.add(new HistoryGetter(generalCfg.getSlackChannels().get(i)));
		}

		//IRC
		if(generalCfg.isConnectIRC())
		{
			for(int i=0;i<generalCfg.getIRCChannels().size();i++)
			{
				String[] channel = generalCfg.getIRCChannels().get(i);
				new Connect(channel[0],Integer.parseInt(channel[1]),channel[2],channel[3]);
			}
		}

		//Streaming gitter_twgitter = new Streaming("S--Minecraft/twgitter");
		//Streaming gitter_PaLTree = new Streaming("PaLTree/notepad-lang-specification");
		//HistoryGetter slackRandom = new HistoryGetter("random");
		/*Connect IRC_parallelnote = *///new Connect("irc.friend-chat.jp",6667,"S_twgitter","#parallelnote");
		/*Connect IRC_twgitter = *///new Connect("irc.friend-chat.jp",6667,"S__twgitter","#S__twgitter");

		/*
		 * Start Thread
		 */

		if(generalCfg.isConnectTwitter())
		{
			twitter.start();
			twitterTweet.start();
		}
		if(generalCfg.isConnectAppNet())
		{
			appNet.start();
		}
		if(generalCfg.isConnectCroudia())
		{
			croudia.start();
		}
		if(generalCfg.isConnectGitter())
		{
			for(int i=0;i<gitter.size();i++)
			{
				gitter.get(i).start();
			}
			//gitter_twgitter.start();
			//gitter_PaLTree.start();
		}
		if(generalCfg.isConnectSlack())
		{
			for(int i=0;i<slack.size();i++)
			{
				slack.get(i).start();
			}
			//slackRandom.start();
		}
	}

	public static void main() throws Exception {
		String[] args = {""};
		main(args);
	}
}
