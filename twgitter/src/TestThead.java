import twgitter.appNet.StreamGetter;
import twgitter.gitter.Streaming;
import twgitter.twitter.UserStream;


public class TestThead extends Thread {
	public void run() {
	    for(int i = 1; i <= 10; i++) {
	      System.out.println(getName() + ":" + i);
	      try {
	        sleep(100);
	      } catch (InterruptedException e) {
	      }
	    }
	  }

	  public static void main(String[] args) throws Exception{
		  StreamGetter thread1 = new StreamGetter();
		  Streaming thread2 = new Streaming();
		  UserStream thread3 = new UserStream();

		  thread1.start();
		  thread3.start();
		  thread2.start("S--Minecraft/twgitter");
	  }
}
