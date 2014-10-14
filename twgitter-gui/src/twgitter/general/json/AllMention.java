package twgitter.general.json;

public class AllMention {
	//返信先のUserの表示名
	String screen_name;
	//返信先のUserのID
	int user_id;
	//返信先のPostのID
	int post_id;
	
	
	public String getScreen_name() {return screen_name;}
	public int getUser_id() {return user_id;}
	public int getPost_id() {return post_id;}
	
	public void setScreen_name(String screen_name) {this.screen_name = screen_name;}
	public void setUser_id(int user_id) {this.user_id = user_id;}
	public void setPost_id(int post_id) {this.post_id = post_id;}
}
