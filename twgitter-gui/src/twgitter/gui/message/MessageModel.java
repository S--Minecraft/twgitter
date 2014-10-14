package twgitter.gui.message;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import twgitter.config.OtherConfig;
import twgitter.general.json.AllMessages;

public class MessageModel {
	OtherConfig otherCfg;
	AllMessages msg;

	private StringProperty appNameStr = new SimpleStringProperty();
	private StringProperty userImageURL = new SimpleStringProperty();
	private StringProperty reUserImageURL = new SimpleStringProperty();
	private StringProperty userNameStr = new SimpleStringProperty();
	private StringProperty userScreenNameStr = new SimpleStringProperty();
	private StringProperty textStr = new SimpleStringProperty();
	private StringProperty createDateStr = new SimpleStringProperty();
	private StringProperty editedDateStr =new SimpleStringProperty();
	private IntegerProperty favCountInt = new SimpleIntegerProperty();
	private IntegerProperty repostCountInt = new SimpleIntegerProperty();
	private IntegerProperty spreadCountInt = new SimpleIntegerProperty();
	private StringProperty appIconP =new SimpleStringProperty();
	private String appIconStr = "";
	private int appIconSize = 32;

	public MessageModel(AllMessages message)
	{
		otherCfg = MessageCellTest.otherConfig;
		msg = message;

		appNameStr.set(/*"Twitter"*/msg.getAppType());
		userImageURL.set("http://sminecraft.page2.jp/_include/img/profile/profile.png"/*msg.getUser().getAvatar_image().getUrl()*/);
		reUserImageURL.set(/*"https://pbs.twimg.com/profile_images/520477561210413056/-jzorU40.png"*/null);
		userNameStr.set(/*"S"*/msg.getUser().getDisplayname());
		userScreenNameStr.set(/*"S__Minecraft"*/msg.getUser().getUsername());
		textStr.set(/*"RTとかの内容ーーーーーー\n\n\n\n\n\n\n\n\n"*/msg.getText());
		createDateStr.set(/*"1970/01/01 00:00:00"*/msg.getCreated_at().toString());
		editedDateStr.set(/*"1970/01/01 00:01:00"*/null);
		favCountInt.set(/*msg.getNum_stars()*/0);
		repostCountInt.set(/*msg.getNum_reposts()*/0);
		spreadCountInt.set(/*msg.getNum_spread()*/0);

		setAppIcon();
	}

	public void setAppIcon()
	{
		switch(otherCfg.getOtherAppIconSize())
		{
		case  16: appIconSize = 16;  break;
		case  32: appIconSize = 32;  break;
		case  64: appIconSize = 64;  break;
		case 128: appIconSize = 128; break;
		default : appIconSize = 32;  break;
		}
		switch(appNameStr.get())
		{
		case "App.net": appIconStr = "app.net-" + appIconSize; break;
		case "Croudia": appIconStr = "croudia-" + appIconSize; break;
		case "Gitter" : appIconStr = "gitter-" + appIconSize;  break;
		case "IRC"    : appIconStr = "IRC-" + appIconSize;     break;
		case "Slack"  : appIconStr = "slack-" + appIconSize;   break;
		case "Twitter": appIconStr = "twitter-" + appIconSize; break;
		default       : appIconStr = "none";                   break;
		}

		appIconP.set(appIconStr);
	}


	public OtherConfig getOtherCfg() {
		return otherCfg;
	}

	public AllMessages getMsg() {
		return msg;
	}

	public StringProperty getAppNameStr() {
		return appNameStr;
	}

	public StringProperty getUserImageURL() {
		return userImageURL;
	}

	public StringProperty getReUserImageURL() {
		return reUserImageURL;
	}

	public StringProperty getUserNameStr() {
		return userNameStr;
	}

	public StringProperty getUserScreenNameStr() {
		return userScreenNameStr;
	}

	public StringProperty getTextStr() {
		return textStr;
	}

	public StringProperty getCreateDateStr() {
		return createDateStr;
	}

	public StringProperty getEditedDateStr() {
		return editedDateStr;
	}

	public IntegerProperty getFavCountInt() {
		return favCountInt;
	}

	public IntegerProperty getRepostCountInt() {
		return repostCountInt;
	}

	public IntegerProperty getSpreadCountInt() {
		return spreadCountInt;
	}

	public StringProperty getAppIconP() {
		return appIconP;
	}

	public String getAppIconStr() {
		return appIconStr;
	}

	public int getAppIconSize() {
		return appIconSize;
	}
}
