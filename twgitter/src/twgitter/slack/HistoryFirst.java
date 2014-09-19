package twgitter.slack;

import java.util.List;

public class HistoryFirst {
	boolean ok;
	List<Message> messages;
	boolean has_more;

	public boolean isOk() {return ok;}
	public List<Message> getMessages() {return messages;}
	public boolean has_more() {return has_more;}
}
