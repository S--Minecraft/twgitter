package twgitter.slack.json;

import java.util.Date;

import twgitter.slack.HistoryGetting;

public class Message {
	Message message;
	String type;
	String subtype;
	String ts;
	String user;
	String text;
	File file;
	Edited edited;
	boolean is_starred;
	boolean wibblr;
	boolean upload;
	boolean hidden;

	public Message getMessage() {return message;}
	public String getType() {return type;}
	public String getSubtype() {return subtype;}
	public String getTs() {return ts;}
	public String getUser() {return user;}
	public String getText() {return text;}
	public File getFile() {return file;}
	public Edited getEdited() {return edited;}
	public boolean isIs_starred() {return is_starred;}
	public boolean isWibblr() {return wibblr;}
	public boolean isUpload() {return upload;}
	public boolean isHidden() {return hidden;}

	public Date getTsDate() {return HistoryGetting.timestampToDate(ts);}
}
