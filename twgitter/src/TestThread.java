import twgitter.appNet.StreamGetterA;
import twgitter.croudia.StreamGetterC;
import twgitter.gitter.Streaming;
import twgitter.twitter.UserStream;


public class TestThread extends Thread {
	public void run() {
	    for(int i = 1; i <= 10; i++) {
	      System.out.println(getName() + ":" + i);
	      try {
	        sleep(500);
	      } catch (InterruptedException e) {
	      }
	    }
	  }

	  public static void main(String[] args) throws Exception{
		  StreamGetterA thread1 = new StreamGetterA();
		  Streaming thread2 = new Streaming("S--Minecraft/twgitter");
		  UserStream thread3 = new UserStream();
		  StreamGetterC thread4 = new StreamGetterC();


		  thread1.start();
		  thread2.start();
		  thread3.start();
		  thread4.start();
	  }
}
