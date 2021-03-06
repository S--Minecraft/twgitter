package twgitter.config;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class AllTokens {
	String AppNetToken;
	String CroudiaConsumerKey;
	String CroudiaConsumerSecret;
	String CroudiaToken;
	String CroudiaAccess_token;
	String CroudiaToken_type;
	int CroudiaExpires_in;
	String CroudiaRefresh_token;
	Date CroudiaGetDate;
	String GitterToken;
	String SlackClientID;
	String SlackClientSecret;
	String SlackToken;
	String TwitterConsumerKey;
	String TwitterConsumerSecret;
	String TwitterAccessToken;
	String TwitterAccessTokenSecret;

	public String getAppNetToken() {return AppNetToken;}
	public String getCroudiaConsumerKey() {return CroudiaConsumerKey;}
	public String getCroudiaConsumerSecret() {return CroudiaConsumerSecret;}
	public String getCroudiaToken() {return CroudiaToken;}
	public String getCroudiaAccess_token() {return CroudiaAccess_token;}
	public String getCroudiaToken_type() {return CroudiaToken_type;}
	public int getCroudiaExpires_in() {return CroudiaExpires_in;}
	public String getCroudiaRefresh_token() {return CroudiaRefresh_token;}
	public Date getCroudiaGetDateDate() {return CroudiaGetDate;}
	public String getGitterToken() {return GitterToken;}
	public String getSlackClientID() {return SlackClientID;}
	public String getSlackClientSecret() {return SlackClientSecret;}
	public String getSlackToken() {return SlackToken;}
	public String getTwitterConsumerKey() {return TwitterConsumerKey;}
	public String getTwitterConsumerSecret() {return TwitterConsumerSecret;}
	public String getTwitterAccessToken() {return TwitterAccessToken;}
	public String getTwitterAccessTokenSecret() {return TwitterAccessTokenSecret;}

	public String getCroudiaGetDateStr() {return CroudiaGetDate.toString();}

	public void setAppNetToken(String appNetToken) {AppNetToken = appNetToken;}
	public void setCroudiaConsumerKey(String croudiaConsumerKey) {CroudiaConsumerKey = croudiaConsumerKey;}
	public void setCroudiaConsumerSecret(String croudiaConsumerSecret) {CroudiaConsumerSecret = croudiaConsumerSecret;}
	public void setCroudiaToken(String croudiaToken) {CroudiaToken = croudiaToken;}
	public void setCroudiaAccess_token(String croudiaAccess_token) {CroudiaAccess_token = croudiaAccess_token;}
	public void setCroudiaToken_type(String croudiaToken_type) {CroudiaToken_type = croudiaToken_type;}
	public void setCroudiaExpires_in(int i) {CroudiaExpires_in = i;}
	public void setCroudiaRefresh_token(String croudiaRefresh_token) {CroudiaRefresh_token = croudiaRefresh_token;}
	public void setCroudiaGetDateDate(Date getToken) {CroudiaGetDate = getToken;}
	public void setGitterToken(String gitterToken) {GitterToken = gitterToken;}
	public void setSlackClientID(String slackClientID) {SlackClientID = slackClientID;}
	public void setSlackClientSecret(String slackClientSecret) {SlackClientSecret = slackClientSecret;}
	public void setSlackToken(String slackToken) {SlackToken = slackToken;}
	public void setTwitterConsumerKey(String twitterConsumerKey) {TwitterConsumerKey = twitterConsumerKey;}
	public void setTwitterConsumerSecret(String twitterConsumerSecret) {TwitterConsumerSecret = twitterConsumerSecret;}
	public void setTwitterAccessToken(String twitterAccessToken) {TwitterAccessToken = twitterAccessToken;}
	public void setTwitterAccessTokenSecret(String twitterAccessTokenSecret) {TwitterAccessTokenSecret = twitterAccessTokenSecret;}

	public void setCroudiaGetDateStr(String getToken) throws ParseException
	{
		SimpleDateFormat sdf = new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy",Locale.ENGLISH);
		CroudiaGetDate = sdf.parse(getToken);
	}
}
