package twgitter.gitter;

import java.util.List;

public class ChatString {
	String id;
	String text;
	String html;
	String sent;
	String editedAt;
	ChatFromUser fromUser;
	String unread;
	String readBy;
	List<Url> urls;
	List<Mention> mentions;
	List<String> issues;
	Meta meta;
	int v;

	public String get(String thing)
	{
		if(thing.equals("id")) return id;
		if(thing.equals("text")) return text;
		if(thing.equals("html")) return html;
		if(thing.equals("sent")) return sent;
		if(thing.equals("editedAt")) return editedAt;
		if(thing.equals("unread")) return unread;
		if(thing.equals("readBy")) return readBy;
		return null;
	}

	public String getId(){return id;}
	public String getText(){return text;}
	public String getHtml(){return html;}
	public String getSent(){return sent;}
	public String getEditedAt(){return editedAt;}
	public String getUnread(){return unread;}
	public String getReadBy(){return readBy;}
	public List<Url> getUrls(){return urls;}
	public List<Mention> getMentions(){return mentions;}
	public List<String> getIssues(){return issues;}
	public Meta getMeta(){return meta;}
	public int getV(){return v;}
	public ChatFromUser getFromUser(){return fromUser;}
}