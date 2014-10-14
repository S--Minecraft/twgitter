package twgitter.appNet.json;

import java.util.ArrayList;
import java.util.List;

import twgitter.general.json.AllHashtag;
import twgitter.general.json.AllLink;
import twgitter.general.json.AllMention;

public class Entities {
	List<Hashtags> hashtags;
	List<Links> links;
	List<Mentions> mentions;

	public List<Hashtags> getHashtags() {return hashtags;}
	public List<Links> getLinks() {return links;}
	public List<Mentions> getMentions() {return mentions;}

	public List<AllHashtag> getListAllHashtag()
	{
		List<AllHashtag> hashes = new ArrayList<>();

		for(int i=0;i<hashtags.size();i++)
		{
			hashes.add(hashtags.get(i).toAllHashtag());
		}

		return hashes;
	}
	public List<AllLink> getListAllLinks()
	{
		List<AllLink> Alinks = new ArrayList<>();

		for(int i=0;i<links.size();i++)
		{
			Alinks.add(links.get(i).toAllHashtag());
		}

		return Alinks;
	}
	public List<AllMention> getListAllMentions()
	{
		List<AllMention> Amentions = new ArrayList<>();

		for(int i=0;i<mentions.size();i++)
		{
			Amentions.add(mentions.get(i).toAllHashtag());
		}

		return Amentions;
	}
}
