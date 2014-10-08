package twgitter.general;

import java.util.Date;
import java.util.List;

public class AllMessages {
	//取得元
	String AppType;


	//Postの実態URL
	String post_url;
	//投稿日時
	Date created_at;
	//編集日時
	Date edited_at;
	//編集者
	AllUser edited_by;


	//Postのタイプ
	String type;
	String sub_type;
	//Postの内容
	String text;
	String html;
	//付加された画像などのメディア
	boolean upload;
	AllEntity entity;
	//ハッシュタグ・リンク・メンション情報
	List<AllHashtag> hashtag;
	List<AllLink> link;
	List<AllMention> mention;
	AllMessages spread;
	String thread_id;//リポストの親PostのID
	List<String> issues;


	//未読かどうか
	boolean unread;
	//既読者
	boolean readBy;


	//PostのID
	String id;


	//リプ数・リポスト数・ファボ数・スプレッド数
	//スプレッド(リポスト&ファボを両方したようなもの)
	int num_replies;
	int num_reposts;
	int num_stars;
	int num_spread;
	//自分がリポスト・ファボ・スプレッドしたか
	boolean you_reposted;
	boolean you_starred;
	boolean you_spreaded;


	//ユーザー情報
	AllUser user;


	//クライアント情報
	ClientInf clientInf;


	//実際に投稿者が投稿したかどうか(APIでないか)
	boolean machine_only;


	//PaginationのID
	int pagination_id;


	//-------------------------IRC----------------
	//エラー・投稿などのタイプ
	String IRCtype;


	//エラーメッセージ
	String error_msg;
	//エラー番号
	String error_num;


	//リプライメッセージ
	String reply_msg;
	//リプライ番号
	String reply_num;


	//チャンネル名
	String chan;
	//トピック名
	String chan_topic;


	//User名前
	String user_name;
	//Userニックネーム
	String user_nickname;
	//User新ニックネーム
	String new_user_nickname;

	//メンション名前
	String mention_name;


	//モード名
	String mode;


	public String getAppType() {return AppType;}
	public String getPost_url() {return post_url;}
	public Date getCreated_at() {return created_at;}
	public Date getEdited_at() {return edited_at;}
	public AllUser getEdited_by() {return edited_by;}
	public String getType() {return type;}
	public String getSub_type() {return sub_type;}
	public String getText() {return text;}
	public String getHtml() {return html;}
	public boolean isUpload() {return upload;}
	public AllEntity getEntity() {return entity;}
	public List<AllHashtag> getHashtag() {return hashtag;}
	public List<AllLink> getLink() {return link;}
	public List<AllMention> getMention() {return mention;}
	public AllMessages getSpread() {return spread;}
	public String getThread_id() {return thread_id;}
	public List<String> getIssues() {return issues;}
	public boolean isUnread() {return unread;}
	public boolean isReadBy() {return readBy;}
	public String getId() {return id;}
	public int getNum_replies() {return num_replies;}
	public int getNum_reposts() {return num_reposts;}
	public int getNum_stars() {return num_stars;}
	public int getNum_spread() {return num_spread;}
	public boolean isYou_reposted() {return you_reposted;}
	public boolean isYou_starred() {return you_starred;}
	public boolean isYou_spreaded() {return you_spreaded;}
	public AllUser getUser() {return user;}
	public ClientInf getClientInf() {return clientInf;}
	public boolean isMachine_only() {return machine_only;}
	public int getPagination_id() {return pagination_id;}
	public String getIRCtype() {return IRCtype;}
	public String getError_msg() {return error_msg;}
	public String getError_num() {return error_num;}
	public String getReply_msg() {return reply_msg;}
	public String getReply_num() {return reply_num;}
	public String getChan() {return chan;}
	public String getChan_topic() {return chan_topic;}
	public String getUser_name() {return user_name;}
	public String getUser_nickname() {return user_nickname;}
	public String getNew_user_nickname() {return new_user_nickname;}
	public String getMention_name() {return mention_name;}
	public String getMode() {return mode;}

	public void setAppType(String appType) {AppType = appType;}
	public void setPost_url(String post_url) {this.post_url = post_url;}
	public void setCreated_at(Date created_at) {this.created_at = created_at;}
	public void setEdited_at(Date edited_at) {this.edited_at = edited_at;}
	public void setEdited_by(AllUser edited_by) {this.edited_by = edited_by;}
	public void setType(String type) {this.type = type;}
	public void setSub_type(String sub_type) {this.sub_type = sub_type;}
	public void setText(String text) {this.text = text;}
	public void setHtml(String html) {this.html = html;}
	public void setUpload(boolean upload) {this.upload = upload;}
	public void setEntity(AllEntity entity) {this.entity = entity;}
	public void setHashtag(List<AllHashtag> hashtag) {this.hashtag = hashtag;}
	public void setLink(List<AllLink> link) {this.link = link;}
	public void setMention(List<AllMention> mention) {this.mention = mention;}
	public void setSpread(AllMessages spread) {this.spread = spread;}
	public void setThread_id(String thread_id) {this.thread_id = thread_id;}
	public void setIssues(List<String> issues) {this.issues = issues;}
	public void setUnread(boolean unread) {this.unread = unread;}
	public void setReadBy(boolean readBy) {this.readBy = readBy;}
	public void setId(String id) {this.id = id;}
	public void setNum_replies(int num_replies) {this.num_replies = num_replies;}
	public void setNum_reposts(int num_reposts) {this.num_reposts = num_reposts;}
	public void setNum_stars(int num_stars) {this.num_stars = num_stars;}
	public void setNum_spread(int num_spread) {this.num_spread = num_spread;}
	public void setYou_reposted(boolean you_reposted) {this.you_reposted = you_reposted;}
	public void setYou_starred(boolean you_starred) {this.you_starred = you_starred;}
	public void setYou_spreaded(boolean you_spreaded) {this.you_spreaded = you_spreaded;}
	public void setUser(AllUser user) {this.user = user;}
	public void setClientInf(ClientInf clientInf) {this.clientInf = clientInf;}
	public void setMachine_only(boolean machine_only) {this.machine_only = machine_only;}
	public void setPagination_id(int pagination_id) {this.pagination_id = pagination_id;}
	public void setIRCtype(String iRCtype) {IRCtype = iRCtype;}
	public void setError_msg(String error_msg) {this.error_msg = error_msg;}
	public void setError_num(String error_num) {this.error_num = error_num;}
	public void setReply_msg(String reply_msg) {this.reply_msg = reply_msg;}
	public void setReply_num(String reply_num) {this.reply_num = reply_num;}
	public void setChan(String chan) {this.chan = chan;}
	public void setChan_topic(String chan_topic) {this.chan_topic = chan_topic;}
	public void setUser_name(String user_name) {this.user_name = user_name;}
	public void setUser_nickname(String user_nickname) {this.user_nickname = user_nickname;}
	public void setNew_user_nickname(String new_user_nickname) {this.new_user_nickname = new_user_nickname;}
	public void setMention_name(String mention_name) {this.mention_name = mention_name;}
	public void setMode(String mode) {this.mode = mode;}
}
