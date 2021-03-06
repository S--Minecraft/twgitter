package twgitter.appNet;

import java.text.ParseException;
import java.util.Date;


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
}
