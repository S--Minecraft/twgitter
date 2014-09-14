package twgitter.croudia;

import java.text.ParseException;
import java.util.Date;

public class CroudiaStream {
	String created_at;
	Entities entities;
	boolean favorited;
	int favorited_count;
	int id;
	String id_str;
	String in_reply_to_screen_name;
	int in_reply_to_status_id;
	String in_reply_to_status_id_str;
	int in_reply_to_user_id;
	String  in_reply_to_user_id_str;
	Source source;
	boolean spread;
	int spread_count;
	Spread_status spread_status;
	String text;
	User user;

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
	public Spread_status getSpreadStatus(){return spread_status;}
	public String getText(){return text;}
	public User getUser(){return user;}

	public Date getCreated_atDate() throws ParseException{return Streaming.croudiaDateStringToDate(created_at);}
}