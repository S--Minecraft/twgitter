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
}
