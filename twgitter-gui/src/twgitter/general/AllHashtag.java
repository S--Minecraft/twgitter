package twgitter.general;

public class AllHashtag {
	//ハッシュタグ名
	String name;
	//ハッシュタグの長さ(#含む) forSubstring
	int len;
	//ハッシュタグの開始位置
	int pos;

	public String getName() {return name;}
	public int getLen() {return len;}
	public int getPos() {return pos;}

	public void setName(String name) {this.name = name;}
	public void setLen(int len) {this.len = len;}
	public void setPos(int pos) {this.pos = pos;}
}
