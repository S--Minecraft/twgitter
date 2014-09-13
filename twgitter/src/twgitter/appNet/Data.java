package twgitter.appNet;

import java.text.ParseException;
import java.util.Date;


public class Data {
	String canonical_url;
	String created_at;
	Entities entities;
	String html;
	String id;
	boolean machine_only;
	int num_replies;
	int num_reposts;
	int num_stars;
	Source source;
	String text;
	String thread_id;
	User user;
	boolean you_reposted;
	boolean you_starred;
	int pagination_id;


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
