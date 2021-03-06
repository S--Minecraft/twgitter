package twgitter.croudia;

import java.lang.reflect.Type;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import twgitter.TestThread;
import twgitter.get.GetHTTP;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class Streaming {
	//curl -k -H "Host: api.croudia.com" -H "Authorization: Bearer 526b902757b640e63a1c09787555ce9acd604e2dfc78efc8cf4e7a6e586de162" https://api.croudia.com/statuses/home_timeline.json

	public static Date streaming(Date lastDate) throws Exception {
		String URI = "https://api.croudia.com/statuses/home_timeline.json";
		String[][] Header = { {"Host", "api.croudia.com"}, {"Authorization", "Bearer " + TestThread.allTokens.getCroudiaAccess_token()}, {"Accept","Application/json"} };
		String CharCode = "UTF-8";
		Gson gson = new Gson();
		List<String> json = new ArrayList<>();
		Date nowGet = new Date();

		try {
			json = GetHTTP.AccessHTTPString(URI,Header,CharCode);
		} catch (Exception e) {
			e.printStackTrace();
			TokenRefresh.refreshToken();
			json = GetHTTP.AccessHTTPString(URI,Header,CharCode);
		}

		String jsonString = json.get(0);

		//System.out.println("C :" + jsonString);

		Type collectionType = new TypeToken<Collection<CroudiaStream>>(){}.getType();
		List<CroudiaStream> stream = gson.fromJson(jsonString.toString(),collectionType);

		for(int i=stream.size()-1;i>=0;i--)
		{
			nowGet = stream.get(i).getCreated_atDate();
			if(nowGet.after(lastDate))
			{
				//System.out.println(lastDate);
				//System.out.println(nowGet);

				User user = stream.get(i).getUser();

				if(stream.get(i).getText() != null)
				{
					System.out.println("[Croudia][" + user.getName() + "(@" + user.getScreen_name()  + ")]" + stream.get(i).getText());
				}
			}
		}

		Date lastGet = new Date();
		lastGet = stream.get(0).getCreated_atDate();

		return lastGet;
	}

	public static Date croudiaDateStringToDate(String dateString) throws ParseException
	{
		Date dateDate = new Date();
		SimpleDateFormat croudiaDate = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss Z",Locale.ENGLISH);
		croudiaDate.setLenient(false);

		dateDate = croudiaDate.parse(dateString);

		return dateDate;
	}
}
