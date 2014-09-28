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
}