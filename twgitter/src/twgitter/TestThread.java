package twgitter;
import java.util.Date;

import twgitter.IRC.Connect;
import twgitter.appNet.StreamGetterA;
import twgitter.config.AllTokens;
import twgitter.config.LoadProperties;
import twgitter.croudia.GetOAuth;
import twgitter.croudia.StreamGetterC;
import twgitter.gitter.Streaming;
import twgitter.slack.HistoryGetter;

public class TestThread extends Thread {
	public static AllTokens allTokens;

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
		AllTokens tokens = LoadProperties.loadTokenConfig();
		allTokens = tokens;

		Date tokenExpirationDate = tokens.getCroudiaGetDateDate();

		tokenExpirationDate.setTime(tokenExpirationDate.getTime() + tokens.getCroudiaExpires_in()*1000);

		if(tokenExpirationDate.before(new Date()))
		{
			GetOAuth.getOAuthCode(tokens);
		}

		//UserStream twitter = new UserStream();

		StreamGetterA appNet = new StreamGetterA();

		StreamGetterC croudia = new StreamGetterC();

		Streaming gitter_twgitter = new Streaming("S--Minecraft/twgitter");
		Streaming gitter_PaLTree = new Streaming("PaLTree/notepad-lang-specification");

		HistoryGetter slackRandom = new HistoryGetter("random");

		/*Connect IRC_parallelnote = */new Connect("irc.friend-chat.jp",6667,"S_twgitter","#parallelnote");
		/*Connect IRC_twgitter = *///new Connect("irc.friend-chat.jp",6667,"S__twgitter","#S__twgitter");

		//twitter.start();
		appNet.start();
		croudia.start();
		gitter_twgitter.start();
		gitter_PaLTree.start();
		slackRandom.start();
	  }
}
