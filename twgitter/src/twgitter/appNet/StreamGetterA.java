package twgitter.appNet;

import java.util.Date;

public class StreamGetterA extends Thread {
	//public static void getStream() throws Exception
	public void run()
	{
		Date lastdate = new Date(0);
		//System.out.println(lastdate);

		for(;;)
		{
			Date newlastdate = new Date();
			try {
				newlastdate = Streaming.streaming(lastdate);
			} catch (Exception e) {
				e.printStackTrace();
			}

			//System.out.println(lastdate);
			//System.out.println(newlastdate);

			lastdate = newlastdate;

			//System.out.println(lastdate);
			//System.out.println(newlastdate);

			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}