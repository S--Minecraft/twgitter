package twgitter.slack.json;

import java.util.List;

public class UserFirst {
	boolean ok;
	List<User> members;
	boolean has_more;

	public boolean isOk() {return ok;}
	public List<User> getMembers() {return members;}
	public boolean has_more() {return has_more;}
}
