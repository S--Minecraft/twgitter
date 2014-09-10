package twgitter.twitter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import twgitter.twitter.config.Config;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.User;
import twitter4j.conf.Configuration;


public class Tweet {
	public static void main(String[] args) throws IOException, TwitterException
	{
		Config.doConfig();
		Configuration cfg=Config.cb.build();
		Twitter twitter = new TwitterFactory(cfg).getInstance();
		String tweet = "";
		Status status = twitter.tweets().updateStatus(tweet);
		User user = status.getUser();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(tweet.isEmpty()) {
			System.out.print("[Twitter]今何してる ? : ");
			tweet = br.readLine();
			if(tweet.length() > 140) {
				System.out.println("[Twitter]字数制限を超えています。");
				tweet = "";
				continue;
			}
		}

		System.out.println("[Twitter]" + user.getScreenName() + " として投稿しました : " + status.getText());
		System.out.println();

		//ユーザ情報取得
		System.out.println("[Twitter]なまえ　　　：" + user.getName());
		System.out.println("[Twitter]ひょうじ名　：" + user.getScreenName());
		System.out.println("[Twitter]ふぉろー数　：" + user.getFriendsCount());
		System.out.println("[Twitter]ふぉろわー数：" + user.getFollowersCount());
    }
}
