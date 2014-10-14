package twgitter.croudia.json;

import java.text.ParseException;
import java.util.Date;

import twgitter.croudia.Streaming;

import com.google.gson.annotations.SerializedName;

public class User {
	String cover_image;				//カバー画像
	String created_at;				//登録日時
	String description;				//説明
	int favorites_count;			//ファボ数
	boolean follow_request_sent;	//フォロー許可要求送信済みか
	int followers_count;			//フォロワー数
	boolean following;				//フォローしているか
	int friends_count;				//フォロー数
	int id;							//UserのID
	String id_str;					//UserのID(String)
	String locataion;				//Userの場所
	String name;					//Userの表示名
	String profile_image_url_https;	//アバター画像
	@SerializedName("protected")
	boolean protect;				//鍵アカかどうか
	String screen_name;				//Userの登録名
	int statuses_count;				//Post数
	String url;						//UserのURL

	public String getCover_image(){return cover_image;}
	public String getCreated_at(){return created_at;}
	public String getDescription(){return description;}
	public int getFavorites_count(){return favorites_count;}
	public boolean getFollow_request_sent(){return follow_request_sent;}
	public int getFollowers_count(){return followers_count;}
	public boolean getFollowing(){return following;}
	public int getFriends_count(){return friends_count;}
	public int getId(){return id;}
	public String getId_str(){return id_str;}
	public String getLocataion(){return locataion;}
	public String getName(){return name;}
	public String getProfile_image_url_https(){return profile_image_url_https;}
	public boolean getProtect(){return protect;}
	public String getScreen_name(){return screen_name;}
	public int getStatuses_count(){return statuses_count;}
	public String getUrl(){return url;}

	public Date getCreated_atDate() throws ParseException{return Streaming.croudiaDateStringToDate(created_at);}
}
