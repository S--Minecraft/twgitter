package twgitter.general.json;

public class AllAvatar_image {
	//画像の高さ
	int height;
	//画像の幅
	int width;


	//デフォルトかどうか
	boolean is_default;


	//画像URL
	String url;
	//画像URL・小
	String url_small;
	//画像URL・中
	String url_medium;


	public int getHeight() {return height;}
	public int getWidth() {return width;}
	public boolean isIs_default() {return is_default;}
	public String getUrl() {return url;}
	public String getUrl_small() {return url_small;}
	public String getUrl_medium() {return url_medium;}

	public void setHeight(int height) {this.height = height;}
	public void setWidth(int width) {this.width = width;}
	public void setIs_default(boolean is_default) {this.is_default = is_default;}
	public void setUrl(String url) {this.url = url;}
	public void setUrl_small(String url_small) {this.url_small = url_small;}
	public void setUrl_medium(String url_medium) {this.url_medium = url_medium;}
}
