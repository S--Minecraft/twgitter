package twgitter.appNet;

import java.text.ParseException;
import java.util.Date;

import twgitter.general.AllMessages;
import twgitter.general.AllUser;


public class Data {
	String canonical_url;	//postの実体のURL
	String created_at;		//作成日時
	Entities entities;		//メンション・ハッシュタグ・リンクの情報
	String html;			//表示のhtml
	String id;				//PostのID
	boolean machine_only;	//実際に投稿者が投稿したかどうか(APIでないか)
	int num_replies;		//リプ数
	int num_reposts;		//リポスト数
	int num_stars;			//ファボ数
	Source source;			//クライアントの情報
	String text;			//Postの内容
	String thread_id;		//親PostのID
	User user;				//投稿者の情報
	boolean you_reposted;	//自分がリポストしたか
	boolean you_starred;	//自分がファボしたか
	int pagination_id;		//PaginationのID

	public String getCranonical_url(){return canonical_url;}
	public String getCreated_at(){return created_at;}
	public Entities getEntities(){return entities;}
	public String getHtml(){return html;}
	public String getId(){return id;}
	public boolean getMachine_only(){return machine_only;}
	public int getNum_replies(){return num_replies;}
	public int getNum_reposts(){return num_reposts;}
	public int getNum_stars(){return num_stars;}
	public Source getSource(){return source;}
	public String getText(){return text;}
	public String getThread_id(){return thread_id;}
	public User getUser(){return user;}
	public boolean getYou_reposted(){return you_reposted;}
	public boolean getYou_starred(){return you_starred;}
	public int getPagination_id(){return pagination_id;}

	public Date getCreated_atDate() throws ParseException{return Streaming.appNetDateStringToDate(created_at);}

	public AllMessages toAllMessages() throws ParseException
	{
		AllMessages msg = new AllMessages();
		AllUser aUser = user.toAllUser();

		msg.setAppType("App.net");
		msg.setPost_url(canonical_url);
		msg.setCreated_at(Streaming.appNetDateStringToDate(created_at));
		msg.setHtml(html);
		msg.setId(id);
		msg.setMachine_only(machine_only);
		msg.setNum_replies(num_replies);
		msg.setNum_reposts(num_reposts);
		msg.setNum_stars(num_stars);
		msg.setText(text);
		msg.setThread_id(thread_id);
		msg.setUser(aUser);
		msg.setYou_reposted(you_reposted);
		msg.setYou_starred(you_starred);
		msg.setPagination_id(pagination_id);

		return msg;
	}
}
