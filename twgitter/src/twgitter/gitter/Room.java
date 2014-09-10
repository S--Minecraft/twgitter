package twgitter.gitter;

public class Room {
	//Roomの枠組み
	String id;
	String name;
	String topic;
	String oneToOne;
	String userCount;
	String unreadItems;
	String mentions;
	String lastAccessTime;
	String lurk;
	String githubType;
	String security;
	String premium;
	String noindex;
	String v;
	String uri;
	String url;

	public String get(String thing)
	{
		if(thing.equals("id")) return id;
		if(thing.equals("name")) return name;
		if(thing.equals("topic")) return topic;
		if(thing.equals("oneToOne")) return oneToOne;
		if(thing.equals("userCount")) return userCount;
		if(thing.equals("unreadItems")) return unreadItems;
		if(thing.equals("mentions")) return mentions;
		if(thing.equals("lastAccessTime")) return lastAccessTime;
		if(thing.equals("lurk")) return lurk;
		if(thing.equals("githubType")) return githubType;
		if(thing.equals("security")) return security;
		if(thing.equals("premium")) return premium;
		if(thing.equals("noindex")) return noindex;
		if(thing.equals("v")) return v;
		if(thing.equals("uri")) return uri;
		if(thing.equals("url")) return url;

		return null;
	}

	public String getId(){return id;}
	public String getName(){return name;}
	public String getTopic(){return topic;}
	public String getOneToOne(){return oneToOne;}
	public String getUserCount(){return userCount;}
	public String getUnreadItems(){return unreadItems;}
	public String getMentions(){return mentions;}
	public String getLastAccessTime(){return lastAccessTime;}
	public String getLurk(){return lurk;}
	public String getGithubType(){return githubType;}
	public String getSecurity(){return security;}
	public String getPremium(){return premium;}
	public String getNoindex(){return noindex;}
	public String getV(){return v;}
	public String getUri(){return uri;}
	public String getUrl(){return url;}
}
