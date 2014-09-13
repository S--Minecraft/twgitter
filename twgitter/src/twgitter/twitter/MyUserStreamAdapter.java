package twgitter.twitter;

import java.text.SimpleDateFormat;
import java.util.Date;

import twitter4j.Status;
import twitter4j.UserStreamAdapter;

public class MyUserStreamAdapter extends UserStreamAdapter {
	@Override
    public void onStatus(Status status) {
        super.onStatus(status);
        twitter4j.User user = status.getUser();

        System.out.println("[Twitter]" + /*"[" + getCurrentDateString() + "]" + */"[" + user.getName() + "(@" + user.getScreenName() + ")]" + status.getText());
    }

	public String getCurrentDateString()
	{
	    Date date = new Date();
	    SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	    return sdf.format(date);
	}

}
