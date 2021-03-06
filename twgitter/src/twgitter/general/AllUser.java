package twgitter.general;

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
}
