package twgitter.croudia;

import java.util.Date;

public class StreamGetterC extends Thread {
	//public static void getStream() throws Exception
	public void run()
	{
		Date lastdate = new Date(0);
		//System.out.println(lastdate);
		System.out.println("[Croudia]Starting up Croudia...");

		for(int i = 0;;i++)
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

			if(i == 300)
			{
				i = 0;
				try {
					TokenRefresh.refreshToken();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
}