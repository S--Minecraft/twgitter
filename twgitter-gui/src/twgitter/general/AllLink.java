package twgitter.general;

public class AllLink {
	//リンク先
	String url;
	//リンクがかかっている文字列
	String text;
	//textの長さ(#含む) forSubstring
	int len;
	//textの開始位置
	int pos;

	
	public String getUrl() {return url;}
	public String getText() {return text;}
	public int getLen() {return len;}
	public int getPos() {return pos;}

	public void setUrl(String url) {this.url = url;}
	public void setText(String text) {this.text = text;}
	public void setLen(int len) {this.len = len;}
	public void setPos(int pos) {this.pos = pos;}
}
