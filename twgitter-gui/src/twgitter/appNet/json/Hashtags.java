package twgitter.appNet.json;

import twgitter.general.json.AllHashtag;

public class Hashtags {
	int len;//ハッシュタグの長さ(#含む) forSubstring
	String name;//ハッシュタグ名
	int pos;//ハッシュタグの開始位置

	public int getLen() {return len;}
	public String getName() {return name;}
	public int getPos() {return pos;}

	public AllHashtag toAllHashtag()
	{
		AllHashtag hash = new AllHashtag();

		hash.setLen(len);
		hash.setName(name);
		hash.setPos(pos);

		return hash;
	}
}
