import twgitter.IRC.Connect;
import twgitter.appNet.StreamGetterA;
import twgitter.croudia.GetOAuth;
import twgitter.croudia.StreamGetterC;
import twgitter.gitter.Streaming;


public class TestThread extends Thread {
	public void run() {
	    for(int i = 1; i <= 10; i++) {
	      System.out.println(getName() + ":" + i);
	      try {
	        sleep(180000);
	      } catch (InterruptedException e) {
	      }
	    }
	  }

	  public static void main(String[] args) throws Exception{
		  GetOAuth.getOAuthCode();

		  //UserStream twitter = new UserStream();

		  StreamGetterA appNet = new StreamGetterA();

		  StreamGetterC croudia = new StreamGetterC();

		  Streaming gitter_twgitter = new Streaming("S--Minecraft/twgitter");
		  Streaming gitter_PaLTree = new Streaming("PaLTree/notepad-lang-specification");

		  Connect IRC_parallelnote = new Connect("irc.friend-chat.jp",6667,"S_twgitter","#parallelnote");
		  Connect IRC_twgitter = new Connect("irc.friend-chat.jp",6667,"S__twgitter","#S__twgitter");

		  //twitter.start();
		  appNet.start();
		  croudia.start();
		  gitter_twgitter.start();
		  gitter_PaLTree.start();
	  }
}
