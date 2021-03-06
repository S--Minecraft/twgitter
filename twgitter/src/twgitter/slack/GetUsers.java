package twgitter.slack;

import java.util.List;

import twgitter.TestThread;
import twgitter.get.GetHTTP;

import com.google.gson.Gson;

public class GetUsers {
	public static String getUsers() throws Exception {
		String URI = "https://slack.com/api/users.list?token=" + TestThread.allTokens.getSlackToken();
		List<String> json = GetHTTP.AccessHTTPString(URI);

		String jsonString = json.get(0);

		return jsonString;
	}

	public static List<User> jsonToUser(String json) {
		Gson gson = new Gson();
		UserFirst userFirst = gson.fromJson(json.toString(),UserFirst.class);
		List<User> users = userFirst.getMembers();
		return users;
	}

	public static String userIdToName(String id, List<User> users) {
		String name = "Couldn't find name...";

		if(id.equals("USLACKBOT"))
		{
			name = "slackbot";
			return name;
		}

		for(int i=0;i<users.size();i++)
		{
			/*
			System.out.println(users.get(i).getId());
			System.out.println(users.get(i).getName());
			*/
			if(id.equals(users.get(i).getId()))
			{
				name = users.get(i).getName();
				/*
				System.out.println(users.get(i).getId());
				System.out.println(users.get(i).getName());
				*/
			}
		}
		return name;
	}
}
