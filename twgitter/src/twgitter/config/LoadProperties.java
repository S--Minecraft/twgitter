package twgitter.config;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import java.util.Properties;

public class LoadProperties {
	public static AllTokens loadTokenConfig() throws ParseException
	{
		String basepath = System.getProperty("java.io.tmpdir");
		String filename = basepath + "\\twgitter\\config\\tokens.cfg";  // プロパティファイルのファイル名

		Properties cfg = new Properties();

		try {
			cfg.load(new FileInputStream(filename));
		} catch (IOException e) {
			System.err.println("Cannot open " + filename + ".");
			e.printStackTrace();
			System.exit(-1);  // プログラム終了
		}

		// 読み込み
		AllTokens tokens = new AllTokens();

		tokens.setAppNetToken(cfg.getProperty("AppNet.token"));
		tokens.setCroudiaConsumerKey(cfg.getProperty("Croudia.ConsumerKey"));
		tokens.setCroudiaConsumerSecret(cfg.getProperty("Croudia.ConsumerSecret"));
		tokens.setCroudiaToken(cfg.getProperty("Croudia.token"));
		tokens.setCroudiaAccess_token(cfg.getProperty("Croudia.access_token"));
		tokens.setCroudiaToken_type(cfg.getProperty("Croudia.token_type"));
		if(cfg.getProperty("Croudia.expires_in").equals("") || cfg.getProperty("Croudia.expires_in").equals(null))
		{
			tokens.setCroudiaExpires_in(0);
		}else{
			tokens.setCroudiaExpires_in(Integer.parseInt(cfg.getProperty("Croudia.expires_in")));
		}
		tokens.setCroudiaRefresh_token(cfg.getProperty("Croudia.refresh_token"));
		if(cfg.getProperty("Croudia.getDate").equals("") || cfg.getProperty("Croudia.getDate").equals(null))
		{
			tokens.setCroudiaGetDateDate(new Date(0));
		}else{
			tokens.setCroudiaGetDateStr(cfg.getProperty("Croudia.getDate"));
		}
		tokens.setGitterToken(cfg.getProperty("Gitter.token"));
		tokens.setSlackClientID(cfg.getProperty("Slack.clientID"));
		tokens.setSlackClientSecret(cfg.getProperty("Slack.clientSecret"));
		tokens.setSlackToken(cfg.getProperty("Slack.token"));
		tokens.setTwitterConsumerKey(cfg.getProperty("Twitter.ConsumerKey"));
		tokens.setTwitterConsumerSecret(cfg.getProperty("Twitter.ConsumerSecret"));
		tokens.setTwitterAccessToken(cfg.getProperty("Twitter.AccessToken"));
		tokens.setTwitterAccessTokenSecret(cfg.getProperty("Twitter.AccessTokenSecret"));

		System.out.println("[Misc][Config]Successfully finished loading the token config.");

		return tokens;
	}

	public static void setTokenConfig(AllTokens allTokens) throws FileNotFoundException, IOException
	{
		String basepath = System.getProperty("java.io.tmpdir");
		String filename = basepath + "\\twgitter\\config\\tokens.cfg";  // プロパティファイルのファイル名

		Properties cfg = new Properties();

		try {
			cfg.load(new FileInputStream(filename));
		} catch (IOException e) {
			System.err.println("Cannot open " + filename + ".");
			e.printStackTrace();
			System.exit(-1);  // プログラム終了
		}

		cfg.setProperty("AppNet.token", allTokens.getAppNetToken());
		cfg.setProperty("Croudia.ConsumerKey", allTokens.getCroudiaConsumerKey());
		cfg.setProperty("Croudia.ConsumerSecret", allTokens.getCroudiaConsumerSecret());
		cfg.setProperty("Croudia.token", allTokens.getCroudiaToken());
		cfg.setProperty("Croudia.access_token", allTokens.getCroudiaAccess_token());
		cfg.setProperty("Croudia.token_type", allTokens.getCroudiaToken_type());
		cfg.setProperty("Croudia.expires_in", String.valueOf(allTokens.getCroudiaExpires_in()));
		cfg.setProperty("Croudia.refresh_token", allTokens.getCroudiaRefresh_token());
		cfg.setProperty("Croudia.getDate", allTokens.getCroudiaGetDateStr());
		cfg.setProperty("Gitter.token", allTokens.getGitterToken());
		cfg.setProperty("Slack.clientID", allTokens.getSlackClientID());
		cfg.setProperty("Slack.clientSecret", allTokens.getSlackClientSecret());
		cfg.setProperty("Slack.token", allTokens.getSlackToken());
		cfg.setProperty("Twitter.ConsumerKey", allTokens.getTwitterConsumerKey());
		cfg.setProperty("Twitter.ConsumerSecret", allTokens.getTwitterConsumerSecret());
		cfg.setProperty("Twitter.AccessToken", allTokens.getTwitterAccessToken());
		cfg.setProperty("Twitter.AccessTokenSecret", allTokens.getTwitterAccessTokenSecret());

		cfg.store(new FileOutputStream(filename), filename);

		System.out.println("[Misc][Config]Successfully finished writing to the token config.");
	}
}
