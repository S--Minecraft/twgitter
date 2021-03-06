package twgitter.slack;

import java.util.Date;
import java.util.List;

import twgitter.gui.Test;
import twgitter.slack.json.Message;

public class HistoryGetting {
	public static Date historyGetting(Date now,String channel) throws Exception {
		GetUsers getU = new GetUsers();

		List<Message> messages = GetChannelHistory.jsonToMessage(GetChannelHistory.getChannelHistory(channel));
		//List<User> users = getU.jsonToList(getU.getJSONString());

		for(int i = messages.size()-1;i>=0;i--)
		{
			Message thisM = messages.get(i);
			String id = "";
			String subtype = thisM.getSubtype();

			if(thisM.getTsDate().after(now) && thisM.getText()!=null)
			{
				if(subtype!=null)
				{
					if(subtype.equals("message_changed"))
					{
						id = thisM.getMessage().getUser();
					}
					if(subtype.equals("file_share")||subtype.equals("channel_join"))
					{
						id = thisM.getUser();
					}
				}else{
					id = thisM.getUser();
				}

				String name = getU.nameToId(id);

				System.out.println("[Slack][#" + channel + "][" + name + "]" + thisM.getText());
				Test.println("[Slack][#" + channel + "][" + name + "]" + thisM.getText());
			}
		}

		Date last = messages.get(0).getTsDate();

		return last;
	}

	public static Date timestampToDate(String ts)
	{
		String forward = ts.substring(0, 10);
		String back = ts.substring(11);

		String newTs = forward + back;

		long unixTimestamp = Long.parseLong(newTs);

		long javaTimestamp = unixTimestamp/1000;

		Date date = new Date(javaTimestamp);
		return date;
	}
}
