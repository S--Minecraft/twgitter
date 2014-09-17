package twgitter.slack;

public class Message {
	String type;
	String ts;
	String user;
	String text;
	boolean is_starred;
	boolean wibblr;

	public String getType() {return type;}
	public String getTs() {return ts;}
	public String getUser() {return user;}
	public String getText() {return text;}
	public boolean isIs_starred() {return is_starred;}
	public boolean isWibblr() {return wibblr;}
}
