package twgitter.general;

import java.util.List;

public class AllDescription {
	//内容
	String html;
	String text;

	//ハッシュタグ・リンク・メンション情報
	List<AllHashtag> hashtag;
	List<AllLink> link;
	List<AllMention> mention;

	//
	AllDiscAnnotation annotations;

	public String getHtml() {return html;}
	public String getText() {return text;}
	public List<AllHashtag> getHashtag() {return hashtag;}
	public List<AllLink> getLink() {return link;}
	public List<AllMention> getMention() {return mention;}
	public AllDiscAnnotation getAnnotations() {return annotations;}

	public void setHtml(String html) {this.html = html;}
	public void setText(String text) {this.text = text;}
	public void setHashtag(List<AllHashtag> hashtag) {this.hashtag = hashtag;}
	public void setLink(List<AllLink> link) {this.link = link;}
	public void setMention(List<AllMention> mention) {this.mention = mention;}
	public void setAnnotations(AllDiscAnnotation annotations) {this.annotations = annotations;}

}