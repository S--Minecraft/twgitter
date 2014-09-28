package twgitter.gitter;

public class Mention {
	String screenName;
	String userId;

	public String get(String thing)
	{
		if(thing.equals("screenName")) return screenName;
		if(thing.equals("userId")) return userId;
		return null;
	}

	public String getScreenName(){return screenName;}
	public String getUserId(){return userId;}
}
