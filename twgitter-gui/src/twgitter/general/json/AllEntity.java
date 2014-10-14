package twgitter.general.json;

import java.util.Date;
import java.util.List;

public class AllEntity {
	//メディアのURL
	String media_url;
	//メディアのタイプ
	String type;


	//メディアID
	String id;
	//投稿日時
	Date time;
	//ファイル名
	String name;
	//タイトル名
	String title;
	//投稿User
	AllUser user;
	//ファイルサイズ
	int size;
	//パブリックかどうか
	boolean is_public;
	boolean public_url_shared;


	//ファイル場所
	List<String> channels;
	List<String> groups;
	List<String> ims;


	//ファイルの種類
	String mimetype;
	String filetype;
	String pretty_type;
	//ファイルモード
	String mode;
	//編集できるか
	boolean editable;


	//URL
	String url;
	String url_download;
	String url_private;
	String url_private_download;
	//link
	String permalink;
	String permalink_public;


	//サムネイル
	String thumb_64;
	String thumb_80;
	String thumb_360;
	String thumb_360_w;
	String thumb_360_h;


	//コメント数
	int num_comment;
	//コメントのID
	int comment_id;
	//コメントの登録日時
	Date comment_date;
	//コメントのユーザー
	AllUser comment_user;
	//コメントの文字列
	String comment;

	//
	boolean is_external;
	String external_type;
	int image_exif_rotation;

	public String getMedia_url() {return media_url;}
	public String getType() {return type;}
	public String getId() {return id;}
	public Date getTime() {return time;}
	public String getName() {return name;}
	public String getTitle() {return title;}
	public AllUser getUser() {return user;}
	public int getSize() {return size;}
	public boolean isIs_public() {return is_public;}
	public boolean isPublic_url_shared() {return public_url_shared;}
	public List<String> getChannels() {return channels;}
	public List<String> getGroups() {return groups;}
	public List<String> getIms() {return ims;}
	public String getMimetype() {return mimetype;}
	public String getFiletype() {return filetype;}
	public String getPretty_type() {return pretty_type;}
	public String getMode() {return mode;}
	public boolean isEditable() {return editable;}
	public String getUrl() {return url;}
	public String getUrl_download() {return url_download;}
	public String getUrl_private() {return url_private;}
	public String getUrl_private_download() {return url_private_download;}
	public String getPermalink() {return permalink;}
	public String getPermalink_public() {return permalink_public;}
	public String getThumb_64() {return thumb_64;}
	public String getThumb_80() {return thumb_80;}
	public String getThumb_360() {return thumb_360;}
	public String getThumb_360_w() {return thumb_360_w;}
	public String getThumb_360_h() {return thumb_360_h;}
	public int getNum_comment() {return num_comment;}
	public int getComment_id() {return comment_id;}
	public Date getComment_date() {return comment_date;}
	public AllUser getComment_user() {return comment_user;}
	public String getComment() {return comment;}
	public boolean isIs_external() {return is_external;}
	public String getExternal_type() {return external_type;}
	public int getImage_exif_rotation() {return image_exif_rotation;}

	public void setMedia_url(String media_url) {this.media_url = media_url;}
	public void setType(String type) {this.type = type;}
	public void setId(String id) {this.id = id;}
	public void setTime(Date time) {this.time = time;}
	public void setName(String name) {this.name = name;}
	public void setTitle(String title) {this.title = title;}
	public void setUser(AllUser user) {this.user = user;}
	public void setSize(int size) {this.size = size;}
	public void setIs_public(boolean is_public) {this.is_public = is_public;}
	public void setPublic_url_shared(boolean public_url_shared) {this.public_url_shared = public_url_shared;}
	public void setChannels(List<String> channels) {this.channels = channels;}
	public void setGroups(List<String> groups) {this.groups = groups;}
	public void setIms(List<String> ims) {this.ims = ims;}
	public void setMimetype(String mimetype) {this.mimetype = mimetype;}
	public void setFiletype(String filetype) {this.filetype = filetype;}
	public void setPretty_type(String pretty_type) {this.pretty_type = pretty_type;}
	public void setMode(String mode) {this.mode = mode;}
	public void setEditable(boolean editable) {this.editable = editable;}
	public void setUrl(String url) {this.url = url;}
	public void setUrl_download(String url_download) {this.url_download = url_download;}
	public void setUrl_private(String url_private) {this.url_private = url_private;}
	public void setUrl_private_download(String url_private_download) {this.url_private_download = url_private_download;}
	public void setPermalink(String permalink) {this.permalink = permalink;}
	public void setPermalink_public(String permalink_public) {this.permalink_public = permalink_public;}
	public void setThumb_64(String thumb_64) {this.thumb_64 = thumb_64;}
	public void setThumb_80(String thumb_80) {this.thumb_80 = thumb_80;}
	public void setThumb_360(String thumb_360) {this.thumb_360 = thumb_360;}
	public void setThumb_360_w(String thumb_360_w) {this.thumb_360_w = thumb_360_w;}
	public void setThumb_360_h(String thumb_360_h) {this.thumb_360_h = thumb_360_h;}
	public void setNum_comment(int num_comment) {this.num_comment = num_comment;}
	public void setComment_id(int comment_id) {this.comment_id = comment_id;}
	public void setComment_date(Date comment_date) {this.comment_date = comment_date;}
	public void setComment_user(AllUser comment_user) {this.comment_user = comment_user;}
	public void setComment(String comment) {this.comment = comment;}
	public void setIs_external(boolean is_external) {this.is_external = is_external;}
	public void setExternal_type(String external_type) {this.external_type = external_type;}
	public void setImage_exif_rotation(int image_exif_rotation) {this.image_exif_rotation = image_exif_rotation;}

}
