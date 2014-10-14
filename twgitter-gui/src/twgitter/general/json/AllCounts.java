package twgitter.general.json;

public class AllCounts {
	//フォロワー数
	int followers;
	//フォロー数
	int following;
	//Post数
	int posts;
	//ファボ数
	int stars;

	public int getFollowers() {return followers;}
	public int getFollowing() {return following;}
	public int getPosts() {return posts;}
	public int getStars() {return stars;}

	public void setFollowers(int followers) {this.followers = followers;}
	public void setFollowing(int following) {this.following = following;}
	public void setPosts(int posts) {this.posts = posts;}
	public void setStars(int stars) {this.stars = stars;}
}
