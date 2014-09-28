package twgitter.appNet;

import java.util.List;

import twgitter.general.AllUser;

public class User {
	Avatar_image avatar_image;	//アバター画像
	String canonical_url;		//Userの実体URL
	Counts counts;				//フォロワー数・フォロー数・Post数・ファボ数
	Cover_image cover_image;	//カバー画像
	String created_at;			//登録日時
	Description description;	//User説明
	String id;					//UserのID
	String locale;				//Userの場所
	String name;				//表示名
	String timezone;			//使用タイムゾーン
	String type;				//ユーザータイプ
	String username;			//登録名
	String verified_domain;		//管理しているURL
	boolean follows_you;			//自分をフォローしているか
	boolean you_blocked;			//自分をブロックしているか
	boolean you_follow;			//自分がフォローしているか
	boolean you_muted;			//自分がミュートしているか
	boolean you_can_subscribe;	//自分がRSSで購読できるか
	boolean you_can_follow;		//自分がフォローできるか
	List<Annotations> annotations;//

	public Avatar_image getAvatar_image(){return avatar_image;}
	public String getCanonicalUrl(){return canonical_url;}
	public Counts getCounts(){return counts;}
	public Cover_image getCover_image(){return cover_image;}
	public String getCreated_at(){return created_at;}
	public Description getDescription(){return description;}
	public String getId(){return id;}
	public String getLocale(){return locale;}
	public String getName(){return name;}
	public String getTimezone(){return timezone;}
	public String getType(){return type;}
	public String getUsername(){return username;}
	public String getVerified_domain(){return verified_domain;}
	public boolean getFollows_you(){return follows_you;}
	public boolean getYou_blocked(){return you_blocked;}
	public boolean getYou_follow(){return you_follow;}
	public boolean getYou_muted(){return you_muted;}
	public boolean getYou_can_subscribe(){return you_can_subscribe;}
	public boolean getYou_can_follow(){return you_can_follow;}
	public List<Annotations> getAnnotations(){return annotations;}

	public AllUser toAllUser() {
		AllUser aUser = new AllUser();

		aUser.setCanonical_url(canonical_url);
		aUser.setUsername(username);
		if(name != null)
		{
			aUser.setDisplayname(name);
		}else{
			aUser.setDisplayname(username);
		}

		return aUser;
	}
}
