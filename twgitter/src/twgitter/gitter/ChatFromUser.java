package twgitter.gitter;

public class ChatFromUser {
	String id;
	String username;
	String displayName;
	String url;
	String avatarUrlSmall;
	String avatarUrlMedium;
	boolean invited;
	int v;

	public String get(String thing)
	{
		if(thing.equals("id")) return id;
		if(thing.equals("username")) return username;
		if(thing.equals("displayName")) return displayName;
		if(thing.equals("url")) return url;
		if(thing.equals("avatarUrlSmall")) return avatarUrlSmall;
		if(thing.equals("avatarUrlMedium")) return avatarUrlMedium;
		return null;
	}


	public String getId(){return id;}
	public String getUsername(){return username;}
	public String getDisplayName(){return displayName;}
	public String getUrl(){return url;}
	public String getAvatarUrlSmall(){return avatarUrlSmall;}
	public String getAvatarUrlMedium(){return avatarUrlMedium;}
	public boolean getInvited(){return invited;}
	public int getV(){return v;}
}
