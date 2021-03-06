package twgitter.config;

import java.util.List;

public class GeneralConfig {
	boolean ConnectTwitter;
	boolean ConnectAppNet;
	boolean ConnectCroudia;
	boolean ConnectGitter;
	boolean ConnectSlack;
	boolean ConnectIRC;
	List<String> GitterRooms;
	List<String> SlackChannels;
	List<String[]> IRCChannels;

	public boolean isConnectTwitter() {return ConnectTwitter;}
	public boolean isConnectAppNet() {return ConnectAppNet;}
	public boolean isConnectCroudia() {return ConnectCroudia;}
	public boolean isConnectGitter() {return ConnectGitter;}
	public boolean isConnectSlack() {return ConnectSlack;}
	public boolean isConnectIRC() {return ConnectIRC;}
	public List<String> getGitterRooms() {return GitterRooms;}
	public List<String> getSlackChannels() {return SlackChannels;}
	public List<String[]> getIRCChannels() {return IRCChannels;}

	public void setConnectTwitter(boolean connectTwitter) {ConnectTwitter = connectTwitter;}
	public void setConnectAppNet(boolean connectAppNet) {ConnectAppNet = connectAppNet;}
	public void setConnectCroudia(boolean connectCroudia) {ConnectCroudia = connectCroudia;}
	public void setConnectGitter(boolean connectGitter) {ConnectGitter = connectGitter;}
	public void setConnectSlack(boolean connectSlack) {ConnectSlack = connectSlack;}
	public void setConnectIRC(boolean connectIRC) {ConnectIRC = connectIRC;}
	public void setGitterRooms(List<String> gitterRooms) {GitterRooms = gitterRooms;}
	public void setSlackChannels(List<String> slackChannels) {SlackChannels = slackChannels;}
	public void setIRCChannels(List<String[]> iRCChannels) {IRCChannels = iRCChannels;}
}
