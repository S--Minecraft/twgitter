package twgitter.general.json;

public class AllCover_image {
	//画像の高さ
	int height;
	//画像の幅
	int width;


	//デフォルトかどうか
	boolean is_default;


	//画像URL
	String url;


	public int getHeight() {return height;}
	public int getWidth() {return width;}
	public boolean isIs_default() {return is_default;}
	public String getUrl() {return url;}

	public void setHeight(int height) {this.height = height;}
	public void setWidth(int width) {this.width = width;}
	public void setIs_default(boolean is_default) {this.is_default = is_default;}
	public void setUrl(String url) {this.url = url;}
}
