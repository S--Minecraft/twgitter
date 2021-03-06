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
}
