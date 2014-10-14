package twgitter.gitter.json;

import java.util.List;

public class ChatString {
	String id;					//PostのID
	String text;				//内容
	String html;				//内容(html)
	String sent;				//投稿日時
	String editedAt;			//編集日時
	ChatFromUser fromUser;		//送信User
	String unread;				//未読かどうか
	String readBy;				//既読者
	List<Url> urls;				//含まれているURL
	List<Mention> mentions;		//メンション先
	List<String> issues;		//関連GithubIssue
	Meta meta;					//
	int v;						//

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
