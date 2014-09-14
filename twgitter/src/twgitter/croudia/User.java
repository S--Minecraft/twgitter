package twgitter.croudia;

import java.text.ParseException;
import java.util.Date;

import com.google.gson.annotations.SerializedName;

public class User {
	String cover_image;
	String created_at;
	String description;
	int favorites_count;
	boolean follow_request_sent;
	int followers_count;
	boolean following;
	int friends_count;
	int id;
	String id_str;
	String locataion;
	String name;
	String profile_image_url_https;
	@SerializedName("protected")
	boolean protect;
	String screen_name;
	int statuses_count;
	String url;

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
