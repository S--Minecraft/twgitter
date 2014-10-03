package twgitter.gui;

import java.io.IOException;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Bounds;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import twgitter.config.OtherConfig;
import twgitter.general.AllMessages;

public class MessageBox {
	public static VBox makeMessageBox(AllMessages msg,OtherConfig otherCfg) throws IOException
	{
		AllMessages Msg = msg;
		String appNameStr = "None";/*msg.getAppType();*/
		String userImageURL = "http://sminecraft.page2.jp/_include/img/profile/profile.png";
		String userNameStr = "S";/*msg.getUser().getDisplayname();*/
		String userScreenNameStr = "S__Minecraft";/*msg.getUser().getUsername();*/
		String textStr = "aaaaaaaaaaaaaa\naaaa\naaaaa\n\n\naaaaaaaaaaaaaaaa\n\n\n\n\naaaaaaaaaaaaaaaaaa\nテステス\n\nfromソース\n600";/*msg.getText();*/
		String createdDateStr = "1970/01/01 00:00:00";/*msg.getCreated_at().toString();//*/
		String editedDateStr = "1970/01/01 00:01:00";
		int favCountInt = 0;/*msg.getNum_stars();*/
		int repostCountInt = 0;/*msg.getNum_reposts();*/
		int spreadCountInt = 0;/*msg.getNum_spread();*/

		String appIconStr = "";
		int appIconSize = 32;
		switch(otherCfg.getOtherAppIconSize())
		{
		case  16: appIconSize = 16;  break;
		case  32: appIconSize = 32;  break;
		case  64: appIconSize = 64;  break;
		case 128: appIconSize = 128; break;
		default : appIconSize = 32;  break;
		}
		switch(appNameStr)
		{
		case "App.net": appIconStr = "app.net-" + appIconSize; break;
		case "Croudia": appIconStr = "croudia-" + appIconSize; break;
		case "Gitter" : appIconStr = "gitter-" + appIconSize;  break;
		case "IRC"    : appIconStr = "IRC-" + appIconSize;     break;
		case "Slack"  : appIconStr = "slack-" + appIconSize;   break;
		case "Twitter": appIconStr = "twitter-" + appIconSize; break;
		default       : appIconStr = "none";                   break;
		}


		VBox out = new VBox();
		out.setStyle("-fx-background-color: #ffffff");

		VBox vbox = new VBox();
		vbox.setStyle("-fx-background-color: #ffffff; -fx-padding: 5 5 5 5");
		out.getChildren().addAll(vbox);

		final HBox main = new HBox();
		HBox bottomFunc = new HBox();
		bottomFunc.setStyle("-fx-background-color: #ffffff");
		vbox.getChildren().addAll(main,bottomFunc);

		/*
		 * Start Main
		 */
		final VBox mainLeft = new VBox();
		final VBox mainMiddle = new VBox();
		main.getChildren().addAll(mainLeft,mainMiddle);

		/*
		 * Start Main/Left
		 */
		VBox appNameBox = new VBox();
		final VBox userContent = new VBox();
		mainLeft.getChildren().addAll(appNameBox,userContent);

		System.out.println("twgitter/assets/socialIcons/"+ appIconStr + ".png");
		Image appIcon = new Image("twgitter/assets/socialIcons/"+ appIconStr + ".png",16,16,false,true);
		ImageView appIconView = new ImageView(appIcon);
		final Label appName = new Label(appNameStr);
		appName.setFont(new Font(10));
		appNameBox.getChildren().addAll(appIconView,appName);

		Image userImage = new Image(userImageURL);
		ImageView userImageView = new ImageView(userImage);
		userImageView.setFitWidth(50);
		userImageView.setFitHeight(50);
		/*
		VBox userNameBox = new VBox();
		VBox userScreenNameBox = new VBox();
		userContent.getChildren().addAll(userImageView,userNameBox,userScreenNameBox);

		Label userName = new Label(userNameStr);
		if(userNameStr.toCharArray().length>2)
		{
			userName.wrapTextProperty().setValue(true);
			userName.ellipsisStringProperty().setValue("…");
		}
		userNameBox.getChildren().addAll(userName);
		Label userScreenName = new Label("@" + userScreenNameStr);
		//Text userScreenName = new Text("@" + userScreenNameStr);
		if(userScreenNameStr.toCharArray().length>2)
		{
			userScreenName.wrapTextProperty().setValue(true);
			userScreenName.ellipsisStringProperty().setValue("…");
		}
		userScreenName.setFont(new Font(10));
		userScreenNameBox.getChildren().addAll(userScreenName);
		*/

		//------------------------------------
		final VBox userNameRoot = new VBox();
		final VBox userScreenNameRoot = new VBox();
		userContent.getChildren().addAll(userImageView,userNameRoot,userScreenNameRoot);

		Label userName = new Label(userNameStr);
		if(userNameStr.toCharArray().length>2)
		{
			userName.wrapTextProperty().setValue(true);
			userName.ellipsisStringProperty().setValue("…");
		}
		Label userScreenName = new Label("@" + userScreenNameStr);
		if(userScreenNameStr.toCharArray().length>2)
		{
			userScreenName.wrapTextProperty().setValue(true);
			userScreenName.ellipsisStringProperty().setValue("…");
		}

		userName.boundsInParentProperty().addListener(new ChangeListener<Bounds>() {
			@Override
			public void changed(ObservableValue<? extends Bounds> ov, Bounds old, Bounds b)
			{
				if(userNameRoot.heightProperty().get()<b.getHeight())
				{
					userNameRoot.minHeightProperty().setValue(b.getHeight());
					/*
					userContent.minHeightProperty().bind(userNameRoot.heightProperty().add(userScreenNameRoot.heightProperty()).add(50));
					mainLeft.minHeightProperty().bind(userContent.heightProperty().add(appName.heightProperty()));
					*/
					//if(mainLeft.minHeightProperty().get() > main.heightProperty().get())
					//{
					//	main.minHeightProperty().setValue(mainLeft.minHeightProperty().get());
					//}
				}
				//System.out.println("[userName]" + b.getHeight());
			}
		});
		userScreenName.boundsInParentProperty().addListener(new ChangeListener<Bounds>() {
			@Override
			public void changed(ObservableValue<? extends Bounds> ov, Bounds old, Bounds b)
			{
				if(userScreenNameRoot.heightProperty().get()<b.getHeight())
				{
					userScreenNameRoot.minHeightProperty().setValue(b.getHeight());
					/*
					userContent.minHeightProperty().bind(userNameRoot.heightProperty().add(userScreenNameRoot.heightProperty()).add(50));
					mainLeft.minHeightProperty().bind(userContent.heightProperty().add(appName.heightProperty()));
					*/
					//if(mainLeft.minHeightProperty().get() > main.heightProperty().get())
					//{
					//	main.minHeightProperty().setValue(mainLeft.minHeightProperty().get());
					//}
				}
				//System.out.println("[userScreenName]" + b.getHeight());
			}
		});
		userNameRoot.getChildren().addAll(userName);
		userScreenNameRoot.getChildren().addAll(userScreenName);
		//------------------------------------


		/*
		 * Start Main/Middle
		 */
		final VBox date = new VBox();
		final VBox textRoot = new VBox();
		mainMiddle.getChildren().addAll(date,textRoot);

		Label text = new Label(textStr);
		text.setStyle("-fx-background-color: #eeeeee");
		if(textStr.toCharArray().length>2)
		{
			text.wrapTextProperty().setValue(true);
		}
		text.boundsInParentProperty().addListener(new ChangeListener<Bounds>() {
			@Override
			public void changed(ObservableValue<? extends Bounds> ov, Bounds old, Bounds b)
			{
				if(textRoot.heightProperty().get()<b.getHeight())
				{
					textRoot.minHeightProperty().setValue(b.getHeight());
					//mainMiddle.minHeightProperty().bind(date.heightProperty().add(textRoot.minHeightProperty()));
					//if(mainMiddle.minHeightProperty().get()>main.heightProperty().get())
					//{
					//	main.minHeightProperty().setValue(mainMiddle.minHeightProperty().get());
					//}
				}
				//System.out.println("[Text]" + b.getHeight());
			}
		});
		textRoot.getChildren().addAll(text);

		Label createDate = new Label(createdDateStr);
		createDate.setFont(new Font(10));
		createDate.setAlignment(Pos.TOP_RIGHT);
		Label editedDate = new Label(editedDateStr + " ");
		editedDate.setFont(new Font(8));
		editedDate.setAlignment(Pos.TOP_RIGHT);
		date.getChildren().addAll(createDate,editedDate);

		/*
		 * Start BottomFunc
		 */
		bottomFunc.setSpacing(120);
		HBox counts = new HBox();
		HBox settings = new HBox();
		bottomFunc.getChildren().addAll(counts,settings);

		VBox favorite = new VBox();
		favorite.setAlignment(Pos.CENTER);
		VBox repost = new VBox();
		repost.setAlignment(Pos.CENTER);
		VBox spread = new VBox();
		spread.setAlignment(Pos.CENTER);
		Button setting = new Button("*");
		Button menu = new Button("≡");
		counts.getChildren().addAll(favorite,repost,spread);
		settings.getChildren().addAll(setting,menu);

		Button btnfavorite = new Button("★");
		Label favCount = new Label(String.valueOf(favCountInt));
		favCount.setFont(new Font(10));
		favorite.getChildren().addAll(btnfavorite,favCount);

		Button btnrepost = new Button("↷");
		Label repostCount = new Label(String.valueOf(repostCountInt));
		repostCount.setFont(new Font(10));
		repost.getChildren().addAll(btnrepost,repostCount);

		Button btnspread = new Button("⇌");
		Label spreadCount = new Label(String.valueOf(spreadCountInt));
		spreadCount.setFont(new Font(10));
		spread.getChildren().addAll(btnspread,spreadCount);

		/*
		 * Set position
		 */
		//Width
		out.minWidthProperty().setValue(300);
		out.maxWidthProperty().setValue(300);
		vbox.minWidthProperty().bind(out.widthProperty().subtract(5.0));
		vbox.maxWidthProperty().bind(out.widthProperty().subtract(5.0));

		main.minWidthProperty().bind(vbox.widthProperty());
		main.maxWidthProperty().bind(vbox.widthProperty());
		bottomFunc.minWidthProperty().bind(vbox.widthProperty());
		bottomFunc.maxWidthProperty().bind(vbox.widthProperty());

		mainLeft.minWidthProperty().setValue(50);
		mainLeft.maxWidthProperty().setValue(50);
		mainMiddle.minWidthProperty().bind(main.widthProperty().subtract(mainLeft.widthProperty()));
		mainMiddle.maxWidthProperty().bind(main.widthProperty().subtract(mainLeft.widthProperty()));

		appNameBox.minWidthProperty().bind(mainLeft.widthProperty());
		appNameBox.maxWidthProperty().bind(mainLeft.widthProperty());
		userContent.minWidthProperty().bind(mainLeft.widthProperty());
		userContent.maxWidthProperty().bind(mainLeft.widthProperty());
		/*
		userNameBox.minWidthProperty().bind(mainLeft.widthProperty());
		userNameBox.maxWidthProperty().bind(mainLeft.widthProperty());
		userScreenNameBox.minWidthProperty().bind(mainLeft.widthProperty());
		userScreenNameBox.maxWidthProperty().bind(mainLeft.widthProperty());
		*/
		//---------------
		userNameRoot.minWidthProperty().bind(mainLeft.widthProperty());
		userNameRoot.maxWidthProperty().bind(mainLeft.widthProperty());
		userScreenNameRoot.minWidthProperty().bind(mainLeft.widthProperty());
		userScreenNameRoot.maxWidthProperty().bind(mainLeft.widthProperty());
		//---------------

		appName.minWidthProperty().bind(appNameBox.widthProperty());
		appName.maxWidthProperty().bind(appNameBox.widthProperty());
		/*
		userName.minWidthProperty().bind(userNameBox.widthProperty());
		userName.maxWidthProperty().bind(userNameBox.widthProperty());
		userScreenName.minWidthProperty().bind(userScreenNameBox.widthProperty());
		userScreenName.maxWidthProperty().bind(userScreenNameBox.widthProperty());
		*/
		//---------------
		userName.minWidthProperty().bind(userNameRoot.widthProperty());
		userName.maxWidthProperty().bind(userNameRoot.widthProperty());
		userScreenName.minWidthProperty().bind(userScreenNameRoot.widthProperty());
		userScreenName.maxWidthProperty().bind(userScreenNameRoot.widthProperty());
		//---------------

		date.minWidthProperty().bind(mainMiddle.widthProperty());
		date.maxWidthProperty().bind(mainMiddle.widthProperty());
		/*
		textBox.minWidthProperty().bind(mainMiddle.widthProperty().subtract(10));
		textBox.maxWidthProperty().bind(mainMiddle.widthProperty().subtract(10));
		text.minWidthProperty().bind(textBox.widthProperty());
		text.maxWidthProperty().bind(textBox.widthProperty());
		*/
		//-----------------
		textRoot.minWidthProperty().bind(mainMiddle.widthProperty().subtract(10));
		textRoot.maxWidthProperty().bind(mainMiddle.widthProperty().subtract(10));
		text.minWidthProperty().bind(textRoot.widthProperty());
		text.maxWidthProperty().bind(textRoot.widthProperty());
		//-----------------
		createDate.minWidthProperty().bind(mainMiddle.widthProperty());
		createDate.maxWidthProperty().bind(mainMiddle.widthProperty());
		editedDate.minWidthProperty().bind(mainMiddle.widthProperty());
		editedDate.maxWidthProperty().bind(mainMiddle.widthProperty());

		//Height
		date.minHeightProperty().bind(createDate.heightProperty().add(editedDate.heightProperty()));

		userContent.minHeightProperty().bind(userNameRoot.heightProperty().add(userScreenNameRoot.heightProperty()).add(50));
		mainLeft.minHeightProperty().bind(userContent.heightProperty().add(appName.heightProperty()));

		mainMiddle.minHeightProperty().bind(date.heightProperty().add(textRoot.minHeightProperty()));

		vbox.minHeightProperty().bind(main.heightProperty().add(bottomFunc.heightProperty()));
		out.minHeightProperty().bind(vbox.heightProperty());

		return out;
	}
}
