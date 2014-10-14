package twgitter.general.json;

import java.util.Date;
import java.util.List;

public class AllUser {
	//取得元
	String AppType;


	//Userの実体URL
	String canonical_url;


	//アバター画像
	AllAvatar_image avatar_image;
	//表示名
	String displayname;
	//登録名
	String username;


	//鍵アカかどうか
	boolean isProtected;


	//カバー画像
	AllCover_image cover_image;
	//UserのID
	String id;
	//User説明
	AllDescription description;
	//フォロワー数・フォロー数・Post数・ファボ数
	AllCounts counts;
	//Userの場所
	String locale;
	//Userの使用タイムゾーン
	String timezone;
	//ユーザーが管理しているURL
	String verified_domain;
	//登録日時
	Date created_at;
	//ユーザータイプ
	String type;

	//自分をフォローしている
	boolean follows_you;
	//自分をブロックしている
	boolean you_blocked;
	//自分がフォローしている
	boolean you_follow;
	//自分がミュートしている
	boolean you_muted;
	//自分がフォロー許可要求を送ったか
	boolean follow_request_sent;
	//自分がRSSで購読できるか
	boolean you_can_subscribe;
	//自分がフォローできるか
	boolean you_can_follow;

	//
	List<AllAnnotation> annotations;

	public String getAppType() {return AppType;}
	public String getCanonical_url() {return canonical_url;}
	public AllAvatar_image getAvatar_image() {return avatar_image;}
	public String getDisplayname() {return displayname;}
	public String getUsername() {return username;}
	public boolean isProtected() {return isProtected;}
	public AllCover_image getCover_image() {return cover_image;}
	public String getId() {return id;}
	public AllDescription getDescription() {return description;}
	public AllCounts getCounts() {return counts;}
	public String getLocale() {return locale;}
	public String getTimezone() {return timezone;}
	public String getVerified_domain() {return verified_domain;}
	public Date getCreated_at() {return created_at;}
	public String getType() {return type;}
	public boolean isFollows_you() {return follows_you;}
	public boolean isYou_blocked() {return you_blocked;}
	public boolean isYou_follow() {return you_follow;}
	public boolean isYou_muted() {return you_muted;}
	public boolean isFollow_request_sent() {return follow_request_sent;}
	public boolean isYou_can_subscribe() {return you_can_subscribe;}
	public boolean isYou_can_follow() {return you_can_follow;}
	public List<AllAnnotation> getAnnotations() {return annotations;}
	
	public void setAppType(String appType) {AppType = appType;}
	public void setCanonical_url(String canonical_url) {this.canonical_url = canonical_url;}
	public void setAvatar_image(AllAvatar_image avatar_image) {this.avatar_image = avatar_image;}
	public void setDisplayname(String displayname) {this.displayname = displayname;}
	public void setUsername(String username) {this.username = username;}
	public void setProtected(boolean isProtected) {this.isProtected = isProtected;}
	public void setCover_image(AllCover_image cover_image) {this.cover_image = cover_image;}
	public void setId(String id) {this.id = id;}
	public void setDescription(AllDescription description) {this.description = description;}
	public void setCounts(AllCounts counts) {this.counts = counts;}
	public void setLocale(String locale) {this.locale = locale;}
	public void setTimezone(String timezone) {this.timezone = timezone;}
	public void setVerified_domain(String verified_domain) {this.verified_domain = verified_domain;}
	public void setCreated_at(Date created_at) {this.created_at = created_at;}
	public void setType(String type) {this.type = type;}
	public void setFollows_you(boolean follows_you) {this.follows_you = follows_you;}
	public void setYou_blocked(boolean you_blocked) {this.you_blocked = you_blocked;}
	public void setYou_follow(boolean you_follow) {this.you_follow = you_follow;}
	public void setYou_muted(boolean you_muted) {this.you_muted = you_muted;}
	public void setFollow_request_sent(boolean follow_request_sent) {this.follow_request_sent = follow_request_sent;}
	public void setYou_can_subscribe(boolean you_can_subscribe) {this.you_can_subscribe = you_can_subscribe;}
	public void setYou_can_follow(boolean you_can_follow) {this.you_can_follow = you_can_follow;}
	public void setAnnotations(List<AllAnnotation> annotations) {this.annotations = annotations;}
}
