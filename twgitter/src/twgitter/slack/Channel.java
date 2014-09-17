package twgitter.slack;

import java.util.ArrayList;
import java.util.List;

public class Channel {
	String id;
	String name;
	String is_channel;
	String created;
	String creator;
	boolean is_archived;
	boolean is_general;
	List<String> members = new ArrayList<String>();
	TopicPurpose topic;
	TopicPurpose purpose;
	boolean is_member;
	String last_read;
	Message lastest;
	int unread_count;

	public String getId() {return id;}
	public String getName() {return name;}
	public String getIs_channel() {return is_channel;}
	public String getCreated() {return created;}
	public String getCreator() {return creator;}
	public boolean isIs_archived() {return is_archived;}
	public boolean isIs_general() {return is_general;}
	public List<String> getMembers() {return members;}
	public TopicPurpose getTopic() {return topic;}
	public TopicPurpose getPurpose() {return purpose;}
	public boolean isIs_member() {return is_member;}
	public String getLast_read() {return last_read;}
	public Message getLastest() {return lastest;}
	public int getUnread_count() {return unread_count;}
}
