package twgitter.twitter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;

import twgitter.TestThread;
import twgitter.config.AllTokens;
import twgitter.config.LoadProperties;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.User;
import twitter4j.conf.Configuration;


public class Tweet extends Thread{
	public Configuration cfg;
	public static void main(String[] args) throws IOException, TwitterException, ParseException
	{
		AllTokens tokens = LoadProperties.loadTokenConfig();
		TestThread.allTokens = tokens;

		GetConfig.doConfig();
		Configuration cfg=GetConfig.cb.build();
		Twitter twitter = new TwitterFactory(cfg).getInstance();
		String tweet = "";

		int i = 0;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(tweet.isEmpty() && i!=-1) {
			System.out.print("[Twitter]つぶやく : ");
			tweet = br.readLine();
			if(tweet.length() > 140) {
				System.out.println("[Twitter]字数制限を超えています。");
				tweet = "";
				continue;
			}
			if(tweet.equals("exit"))
			{
				i = -1;
			}else{
				Status status = twitter.updateStatus(tweet);
				User user = status.getUser();
				System.out.println("[Twitter]" + user.getScreenName() + " として投稿しました : " + status.getText());
				tweet = "";
			}
		}
		System.out.println("!!!!!Finished!!!!!!!!!");

		//ユーザ情報取得
		/*
		System.out.println("[Twitter]なまえ　　　：" + user.getName());
		System.out.println("[Twitter]ひょうじ名　：" + user.getScreenName());
		System.out.println("[Twitter]ふぉろー数　：" + user.getFriendsCount());
		System.out.println("[Twitter]ふぉろわー数：" + user.getFollowersCount());
		*/
    }

	public void run()
	{
		Twitter twitter = new TwitterFactory(cfg).getInstance();
		String tweet = "";

		int i = 0;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(tweet.isEmpty() && i!=-1) {
			System.out.print("[Twitter]つぶやく : ");
			try {
				tweet = br.readLine();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			if(tweet.length() > 140) {
				System.out.println("[Twitter]字数制限を超えています。");
				tweet = "";
				continue;
			}
			if(tweet.equals("exit"))
			{
				i = -1;
			}else{
				Status status;
				try {
					status = twitter.updateStatus(tweet);
					User user = status.getUser();
					System.out.println("[Twitter]" + user.getScreenName() + " として投稿しました : " + status.getText());
				} catch (TwitterException e) {
					e.printStackTrace();
				}
				tweet = "";
			}
		}
		System.out.println("[Twitter]TweetModule!!!!!Finished!!!!!!!!!");
	}

	public Tweet(Configuration cfg)
	{
		this.cfg = cfg;
	}
}
