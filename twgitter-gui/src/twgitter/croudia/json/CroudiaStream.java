package twgitter.croudia.json;

import java.text.ParseException;
import java.util.Date;

import twgitter.croudia.Streaming;

public class CroudiaStream {
	String created_at;					//投稿日時
	Entities entities;					//付加された画像などのメディア
	boolean favorited;					//自分がファボしている
	int favorited_count;				//ファボ数
	int id;								//PostのID
	String id_str;						//PostのID(String)
	String in_reply_to_screen_name;		//返信先のUserの表示名
	int in_reply_to_status_id;			//返信先のPostのID
	String in_reply_to_status_id_str;	//返信先のPostのID(String)
	int in_reply_to_user_id;			//返信先のUserのID
	String  in_reply_to_user_id_str;	//返信先のUserのID(String)
	Source source;						//クライアントの情報
	boolean spread;						//スプレッドしたか
	int spread_count;					//スプレッド数
	CroudiaStream spread_status;		//スプレッド元の情報
	String text;						//投稿内容
	User user;							//投稿したユーザー

	public String getCreated_at(){return created_at;}
	public Entities getEntities(){return entities;}
	public boolean getFavorited(){return favorited;}
	public int getFavorited_count(){return favorited_count;}
	public int getId(){return id;}
	public String getId_str(){return id_str;}
	public String getIn_reply_to_screen_name(){return in_reply_to_screen_name;}
	public int getIn_reply_to_status_id(){return in_reply_to_status_id;}
	public String getIn_reply_to_status_id_str(){return in_reply_to_status_id_str;}
	public int getIn_reply_to_user_id(){return in_reply_to_user_id;}
	public String getIn_reply_to_user_id_str(){return in_reply_to_user_id_str;}
	public Source getSource(){return source;}
	public boolean getSpread(){return spread;}
	public int getSpread_count(){return spread_count;}
	public String getText(){return text;}
	public User getUser(){return user;}

	public Date getCreated_atDate() throws ParseException{return Streaming.croudiaDateStringToDate(created_at);}
}
