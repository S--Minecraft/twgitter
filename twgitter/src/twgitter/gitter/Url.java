package twgitter.gitter;

public class Url {
	String url;

	public String get(String thing)
	{
		if(thing.equals("url")) return url;
		return null;
	}

	public String getUrl(){return url;}
}
