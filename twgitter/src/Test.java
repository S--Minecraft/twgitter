import twgitter.gitter.Streaming;



public class Test {
	public static void main(String[] args) throws Exception {
		/*
		StreamGetter appNet = new StreamGetter();
		appNet.run();
		*/
		Streaming gitter = new Streaming();
		gitter.run("S--Minecraft/twgitter");
		/*
		UserStream twitter = new UserStream();
		twitter.run();
		*/

		//GetMessages.getMessages("irc.friend-chat.jp:6667","S__twgitter");

	}
}