package twgitter.gitter;

public class Room {
	//Roomの枠組み
	String id;
	String name;
	String topic;
	boolean oneToOne;
	User user;
	int userCount;
	int unreadItems;
	int mentions;
	String lastAccessTime;
	boolean lurk;
	String githubType;
	String security;
	boolean premium;
	boolean noindex;
	int v;
	String uri;
	String url;

	public String get(String thing)
	{
		if(thing.equals("id")) return id;
		if(thing.equals("name")) return name;
		if(thing.equals("topic")) return topic;
		if(thing.equals("lastAccessTime")) return lastAccessTime;
		if(thing.equals("githubType")) return githubType;
		if(thing.equals("security")) return security;
		if(thing.equals("uri")) return uri;
		if(thing.equals("url")) return url;

		return null;
	}

	public String getId(){return id;}
	public String getName(){return name;}
	public String getTopic(){return topic;}
	public boolean getOneToOne(){return oneToOne;}
	public User getUser(){return user;}
	public int getUserCount(){return userCount;}
	public int getUnreadItems(){return unreadItems;}
	public int getMentions(){return mentions;}
	public String getLastAccessTime(){return lastAccessTime;}
	public boolean getLurk(){return lurk;}
	public String getGithubType(){return githubType;}
	public String getSecurity(){return security;}
	public boolean getPremium(){return premium;}
	public boolean getNoindex(){return noindex;}
	public int getV(){return v;}
	public String getUri(){return uri;}
	public String getUrl(){return url;}
}
