package twgitter.slack;

import java.util.List;

import twgitter.TestThread;
import twgitter.get.GetHTTP;
import twgitter.get.GetJsonThenListI;
import twgitter.slack.json.User;
import twgitter.slack.json.UserFirst;

import com.google.gson.Gson;

public class GetUsers implements GetJsonThenListI{
	public List<User> users;
	/**
	 * jsonを取得する
	 *
	 * @return channelの情報のjson
	 * @throws Exception
	 */
	@Override
	public String getJSONString() throws Exception {
		String URI = "https://slack.com/api/users.list?token=" + TestThread.allTokens.getSlackToken();
		List<String> json = GetHTTP.AccessHTTPString(URI);

		String jsonString = json.get(0);

		return jsonString;
	}

	@Override
	public List<User> jsonToList(String json) {
		Gson gson = new Gson();
		UserFirst userFirst = gson.fromJson(json.toString(),UserFirst.class);
		List<User> users = userFirst.getMembers();
		this.users = users;
		return users;
	}

	@Override
	public String nameToId(String wantNameOrId) throws Exception {
		String name = "Couldn't find name...";

		if(wantNameOrId.equals("USLACKBOT"))
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
			if(wantNameOrId.equals(users.get(i).getId()))
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
