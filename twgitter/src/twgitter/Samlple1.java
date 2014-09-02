package twgitter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import twgitter.config.Config;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.User;

public class Samlple1 {
	public static void main(String[] args) throws IOException, TwitterException
	{
		Config.doConfig();
		Twitter twitter = new TwitterFactory(Config.cb.build()).getInstance();
		String tweet = "";
		Status status = twitter.tweets().updateStatus(tweet);
		User user = status.getUser();



		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(tweet.isEmpty()) {
			System.out.print("今何してる ? : ");
			tweet = br.readLine();
			if(tweet.length() > 140) {
				System.out.println("字数制限を超えています。");
				tweet = "";
				continue;
			}
		}

		System.out.println(user.getScreenName() + " として投稿しました : " + status.getText());
		System.out.println();

		//ユーザ情報取得
		System.out.println("なまえ　　　：" + user.getName());
		System.out.println("ひょうじ名　：" + user.getScreenName());
		System.out.println("ふぉろー数　：" + user.getFriendsCount());
		System.out.println("ふぉろわー数：" + user.getFollowersCount());

    }
}
