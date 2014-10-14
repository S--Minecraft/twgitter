package twgitter.appNet.json;

import twgitter.general.json.AllLink;

public class Links {
	int len;//textの長さ(#含む) forSubstring
	int pos;//textの開始位置
	String text;//リンクがかかっている文字列
	String url;//リンク先

	public int getLen() {return len;}
	public int getPos() {return pos;}
	public String getText() {return text;}
	public String getUrl() {return url;}

	public AllLink toAllHashtag()
	{
		AllLink link = new AllLink();

		link.setLen(len);
		link.setPos(pos);
		link.setText(text);
		link.setUrl(url);

		return link;
	}
}