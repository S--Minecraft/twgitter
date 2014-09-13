package twgitter.appNet;

import java.util.List;

public class User {
	Avatar_image avatar_image;
	String canonical_url;
	Counts counts;
	Cover_image cover_image;
	String created_at;
	Description description;
	String id;
	String locale;
	String name;
	String timezone;
	String type;
	String username;
	String verified_domain;
	String follows_you;
	String you_blocked;
	String you_follow;
	String you_muted;
	boolean you_can_subscribe;
	boolean you_can_follow;
	List<Annotations> annotations;

	public Avatar_image getAvatar_image(){return avatar_image;}
	public String getCanonicalUrl(){return canonical_url;}
	public Counts getCounts(){return counts;}
	public Cover_image getCover_image(){return cover_image;}
	public String getCreated_at(){return created_at;}
	public Description getDescription(){return description;}
	public String getId(){return id;}
	public String getLocale(){return locale;}
	public String getName(){return name;}
	public String getTimezone(){return timezone;}
	public String getType(){return type;}
	public String getUsername(){return username;}
	public String getVerified_domain(){return verified_domain;}
	public String getFollows_you(){return follows_you;}
	public String getYou_blocked(){return you_blocked;}
	public String getYou_follow(){return you_follow;}
	public String getYou_muted(){return you_muted;}
	public boolean getYou_can_subscribe(){return you_can_subscribe;}
	public boolean getYou_can_follow(){return you_can_follow;}
	public List<Annotations> getAnnotations(){return annotations;}
}
