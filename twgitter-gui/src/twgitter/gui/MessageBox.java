package twgitter.gui;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import twgitter.general.AllMessages;

public class MessageBox {
	public static VBox makeMessageBox(AllMessages msg)
	{
		String appNameStr = msg.getAppType();//"Twitter";
		String userImageURL = "http://sminecraft.page2.jp/_include/img/profile/profile.png";
		String userNameStr = msg.getUser().getDisplayname();//"S";
		String userScreenNameStr = msg.getUser().getUsername();//"S__Minecraft";
		String textStr = msg.getText();//"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\nテステス\n\nfromソース\n600";
		String createdDateStr = msg.getCreated_at().toString();//"1970/01/01 00:00:00";
		String editedDateStr = "";
		/*
		if(msg.getEdited_at().toString() != null)
		{
			editedDateStr = msg.getEdited_at().toString();//"1970/01/01 00:01:00";
		}
		*/
		int favCountInt = msg.getNum_stars();//0;
		int repostCountInt = msg.getNum_reposts();//0;
		int spreadCountInt = msg.getNum_spread();//0;

		VBox out = new VBox();
		out.setStyle("-fx-background-color: #ffffff");

		VBox vbox = new VBox();
		vbox.setStyle("-fx-background-color: #ffffff; -fx-padding: 5 5 5 5");
		out.getChildren().addAll(vbox);

		HBox main = new HBox();
		HBox bottomFunc = new HBox();
		bottomFunc.setStyle("-fx-background-color: #ffffff");
		vbox.getChildren().addAll(main,bottomFunc);

		/*
		 * Start Main
		 */
		VBox mainLeft = new VBox();
		VBox mainMiddle = new VBox();
		main.getChildren().addAll(mainLeft,mainMiddle);

		/*
		 * Start Main/Left
		 */
		VBox appNameBox = new VBox();
		VBox userContent = new VBox();
		mainLeft.getChildren().addAll(appNameBox,userContent);

		Label appName = new Label(appNameStr);
		appName.setFont(new Font(10));
		appNameBox.getChildren().addAll(appName);

		Image userImage = new Image(userImageURL);
		ImageView userImageView = new ImageView(userImage);
		userImageView.setFitWidth(50);
		userImageView.setFitHeight(50);
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

		/*
		 * Start Main/Middle
		 */
		VBox date = new VBox();
		VBox textBox = new VBox();
		mainMiddle.getChildren().addAll(date,textBox);

		Label text = new Label(textStr);
		text.setStyle("-fx-background-color: #eeeeee");
		if(textStr.toCharArray().length>2)
		{
			text.wrapTextProperty().setValue(true);
		}
		textBox.getChildren().addAll(text);

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
		userNameBox.minWidthProperty().bind(mainLeft.widthProperty());
		userNameBox.maxWidthProperty().bind(mainLeft.widthProperty());
		userScreenNameBox.minWidthProperty().bind(mainLeft.widthProperty());
		userScreenNameBox.maxWidthProperty().bind(mainLeft.widthProperty());

		appName.minWidthProperty().bind(appNameBox.widthProperty());
		appName.maxWidthProperty().bind(appNameBox.widthProperty());
		userName.minWidthProperty().bind(userNameBox.widthProperty());
		userName.maxWidthProperty().bind(userNameBox.widthProperty());
		userScreenName.minWidthProperty().bind(userScreenNameBox.widthProperty());
		userScreenName.maxWidthProperty().bind(userScreenNameBox.widthProperty());

		date.minWidthProperty().bind(mainMiddle.widthProperty());
		date.maxWidthProperty().bind(mainMiddle.widthProperty());
		textBox.minWidthProperty().bind(mainMiddle.widthProperty().subtract(10));
		textBox.maxWidthProperty().bind(mainMiddle.widthProperty().subtract(10));
		text.minWidthProperty().bind(textBox.widthProperty());
		text.maxWidthProperty().bind(textBox.widthProperty());
		createDate.minWidthProperty().bind(mainMiddle.widthProperty());
		createDate.maxWidthProperty().bind(mainMiddle.widthProperty());
		editedDate.minWidthProperty().bind(mainMiddle.widthProperty());
		editedDate.maxWidthProperty().bind(mainMiddle.widthProperty());

		//Height
		/*
		if(userNameBox.maxHeightProperty().get() + userScreenNameBox.maxHeightProperty().get() + 50 + appNameBox.maxHeightProperty().get() > main.heightProperty().get())
		{
			main.minHeightProperty().setValue(userNameBox.maxHeightProperty().get() + userScreenNameBox.maxHeightProperty().get() + 50 + appNameBox.maxHeightProperty().get());
		}

		userContent.minHeightProperty().bind(userNameBox.heightProperty().add(userScreenNameBox.heightProperty()).add(50));
		userContent.maxHeightProperty().bind(userNameBox.heightProperty().add(userScreenNameBox.heightProperty()).add(50));
		mainLeft.minHeightProperty().bind(userContent.heightProperty().add(appName.heightProperty()));
		mainLeft.maxHeightProperty().bind(userContent.heightProperty().add(appName.heightProperty()));
		/*
		date.minHeightProperty().bind(createDate.heightProperty().add(editedDate.heightProperty()));
		date.maxHeightProperty().bind(createDate.heightProperty().add(editedDate.heightProperty()));
		text.minHeightProperty().setValue(text.maxHeightProperty().get());
		mainMiddle.minHeightProperty().bind(date.heightProperty().add(text.maxHeightProperty()));
		mainMiddle.maxHeightProperty().bind(date.heightProperty().add(text.maxHeightProperty()));
		*/

		/*
		DoubleProperty biggerHeightProperty = new SimpleDoubleProperty();
		if(mainLeft.heightProperty().get() < mainMiddle.heightProperty().get())
		{
			biggerHeightProperty.add(mainMiddle.heightProperty());
		}else if(mainMiddle.heightProperty().get() <= mainLeft.heightProperty().get()){
			biggerHeightProperty.add(mainLeft.heightProperty());
		}else{
			biggerHeightProperty.add(mainMiddle.heightProperty());
		}
		main.minHeightProperty().bind(biggerHeightProperty);
		main.maxHeightProperty().bind(biggerHeightProperty);
		*/

		/*
		ReadOnlyDoubleProperty biggestHeightProperty;
		if(mainLeft.heightProperty().get() < mainMiddle.heightProperty().get())
		{
			biggestHeightProperty = mainMiddle.heightProperty();
		}else if(mainMiddle.heightProperty().get() <= mainLeft.heightProperty().get()){
			biggestHeightProperty = mainLeft.heightProperty();
		}else{
			biggestHeightProperty = mainMiddle.heightProperty();
		}


		vbox.minHeightProperty().bind(biggestHeightProperty.add(bottomFunc.heightProperty()));
		*/

		return out;
	}
}
