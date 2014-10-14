package twgitter.slack.json;

import java.util.List;

public class File {
	String id;
	int timestamp;
	String name;
	String title;
	String mimetype;
	String filetype;
	String pretty_type;
	String user;
	boolean editable;
	int size;
	String mode;
	boolean is_external;
	String external_type;
	boolean is_public;
	boolean public_url_shared;
	String url;
	String url_download;
	String url_private;
	String url_private_download;
	String thumb_64;
	String thumb_80;
	String thumb_360;
	String thumb_360_w;
	String thumb_360_h;
	int image_exif_rotation;
	String permalink;
	String permalink_public;
	List<String> channels;
	List<String> groups;
	List<String> ims;
	int comments_count;
	Initial_comment initial_comment;

	public String getId() {return id;}
	public int getTimestamp() {return timestamp;}
	public String getName() {return name;}
	public String getTitle() {return title;}
	public String getMimetype() {return mimetype;}
	public String getFiletype() {return filetype;}
	public String getPretty_type() {return pretty_type;}
	public String getUser() {return user;}
	public boolean getEditable() {return editable;}
	public int getSize() {return size;}
	public String getMode() {return mode;}
	public boolean isIs_external() {return is_external;}
	public String getExternal_type() {return external_type;}
	public boolean isIs_public() {return is_public;}
	public boolean isPublic_url_shared() {return public_url_shared;}
	public String getUrl() {return url;}
	public String getUrl_download() {return url_download;}
	public String getUrl_private() {return url_private;}
	public String getUrl_private_download() {return url_private_download;}
	public String getThumb_64() {return thumb_64;}
	public String getThumb_80() {return thumb_80;}
	public String getThumb_360() {return thumb_360;}
	public String getThumb_360_w() {return thumb_360_w;}
	public String getThumb_360_h() {return thumb_360_h;}
	public int getImage_exif_rotation() {return image_exif_rotation;}
	public String getPermalink() {return permalink;}
	public String getPermalink_public() {return permalink_public;}
	public List<String> getChannels() {return channels;}
	public List<String> getGroups() {return groups;}
	public List<String> getIms() {return ims;}
	public int getComments_count() {return comments_count;}
	public Initial_comment getInitial_comment() {return initial_comment;}
}
