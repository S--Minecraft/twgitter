package twgitter.slack;

import java.util.Date;

public class HistoryGetter extends Thread {
	public String ChannelName;

	public HistoryGetter(String channel) {
		ChannelName = channel;
		//System.out.println(ChannelName);
	}

	//public static void getStream() throws Exception
		public void run()
		{
			Date lastdate = new Date(0);
			//System.out.println(lastdate);
			System.out.println("[Slack]Starting up Slack...");

			for(;;)
			{
				Date newlastdate = new Date();
				try {
					newlastdate = HistoryGetting.historyGetting(lastdate,ChannelName);
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
