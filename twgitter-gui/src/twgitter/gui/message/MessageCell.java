package twgitter.gui.message;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class MessageCell extends ListCell<MessageModel>{
	private VBox out;
	private VBox vbox;
	private HBox main;
	private HBox bottomFunc;
	private VBox mainLeft;
	private VBox mainMiddle;
	private VBox appNameBox;
	private VBox userContent;
	private ImageView appIconView;
	private Label appName;
	private StackPane userImages;
	private ImageView userImageView;
	private ImageView reUserImageView;
	private VBox userNameRoot;
	private VBox userScreenNameRoot;
	private Label userName;
	private Hyperlink userScreenName;
	private VBox date;
	private VBox textRoot;
	private Label text;
	private Label createDate;
	private Label editedDate;
	private HBox counts;
	private HBox settings;
	private VBox favorite;
	private VBox repost;
	private VBox spread;
	private Button setting;
	private Button menu;
	private Button btnfavorite;
	private Label favCount;
	private Button btnrepost;
	private Label repostCount;
	private Button btnspread;
	private Label spreadCount;

	private boolean bound = false;

	public MessageCell(){
		init();
	}

	private void init(){
		out = new VBox();
		out.setStyle("-fx-background-color: #ffffff");

		vbox = new VBox();
		vbox.setStyle("-fx-background-color: #ffffff; -fx-padding: 5 5 5 5");
		out.getChildren().addAll(vbox);

		main = new HBox();
		bottomFunc = new HBox();
		bottomFunc.setStyle("-fx-background-color: #ffffff");
		vbox.getChildren().addAll(main,bottomFunc);

		/*
		 * Start Main
		 */
		mainLeft = new VBox();
		mainMiddle = new VBox();
		main.getChildren().addAll(mainLeft,mainMiddle);

		/*
		 * Start Main/Left
		 */
		appNameBox = new VBox();
		userContent = new VBox();
		mainLeft.getChildren().addAll(appNameBox,userContent);

		appIconView = new ImageView();
		appName = new Label();
		appName.setFont(new Font(10));
		appNameBox.getChildren().addAll(appIconView,appName);

		userImages = new StackPane();
		userImages.setAlignment(Pos.BOTTOM_RIGHT);
		userImageView = new ImageView();
		userImageView.setFitWidth(50);
		userImageView.setFitHeight(50);
		reUserImageView = new ImageView();
		reUserImageView.setFitWidth(20);
		reUserImageView.setFitHeight(20);
		userImages.getChildren().addAll(userImageView,reUserImageView);

		userNameRoot = new VBox();
		userScreenNameRoot = new VBox();
		userContent.getChildren().addAll(userImages,userNameRoot,userScreenNameRoot);

		userName = new Label();
		userScreenName = new Hyperlink();
		userNameRoot.getChildren().addAll(userName);
		userScreenNameRoot.getChildren().addAll(userScreenName);

		/*
		 * Start Main/Middle
		 */
		date = new VBox();
		textRoot = new VBox();
		mainMiddle.getChildren().addAll(date,textRoot);

		text = new Label();
		text.setStyle("-fx-background-color: #eeeeee");
		textRoot.getChildren().addAll(text);

		createDate = new Label();
		createDate.setFont(new Font(10));
		createDate.setAlignment(Pos.TOP_RIGHT);
		editedDate = new Label();
		editedDate.setFont(new Font(8));
		editedDate.setAlignment(Pos.TOP_RIGHT);
		date.getChildren().addAll(createDate,editedDate);

		/*
		 * Start BottomFunc
		 */
		bottomFunc.setSpacing(120);
		counts = new HBox();
		settings = new HBox();
		bottomFunc.getChildren().addAll(counts,settings);

		favorite = new VBox();
		favorite.setAlignment(Pos.CENTER);
		repost = new VBox();
		repost.setAlignment(Pos.CENTER);
		spread = new VBox();
		spread.setAlignment(Pos.CENTER);
		setting = new Button("*");
		menu = new Button("≡");
		counts.getChildren().addAll(favorite,repost,spread);
		settings.getChildren().addAll(setting,menu);

		btnfavorite = new Button("★");
		favCount = new Label();
		favCount.setFont(new Font(10));
		favorite.getChildren().addAll(btnfavorite,favCount);

		btnrepost = new Button("↷");
		repostCount = new Label();
		repostCount.setFont(new Font(10));
		repost.getChildren().addAll(btnrepost,repostCount);

		btnspread = new Button("⇌");
		spreadCount = new Label();
		spreadCount.setFont(new Font(10));
		spread.getChildren().addAll(btnspread,spreadCount);
	}

	@Override
	protected void updateItem(MessageModel msgModel, boolean empty)
	{
		super.updateItem(msgModel, empty);

		if(!bound){
			//txtTweet.wrappingWidthProperty().bind(getListView().widthProperty().subtract(25));
			out.minWidthProperty().setValue(300);
			out.maxWidthProperty().setValue(300);
			bound = true;
		}
		if(empty){
			setText(null);
			setGraphic(null);
		}else{
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
			userNameRoot.minWidthProperty().bind(mainLeft.widthProperty());
			userNameRoot.maxWidthProperty().bind(mainLeft.widthProperty());
			userScreenNameRoot.minWidthProperty().bind(mainLeft.widthProperty());
			userScreenNameRoot.maxWidthProperty().bind(mainLeft.widthProperty());

			appName.minWidthProperty().bind(appNameBox.widthProperty());
			appName.maxWidthProperty().bind(appNameBox.widthProperty());
			userName.minWidthProperty().bind(userNameRoot.widthProperty());
			userName.maxWidthProperty().bind(userNameRoot.widthProperty());
			userScreenName.minWidthProperty().bind(userScreenNameRoot.widthProperty());
			userScreenName.maxWidthProperty().bind(userScreenNameRoot.widthProperty());

			date.minWidthProperty().bind(mainMiddle.widthProperty());
			date.maxWidthProperty().bind(mainMiddle.widthProperty());
			textRoot.minWidthProperty().bind(mainMiddle.widthProperty().subtract(10));
			textRoot.maxWidthProperty().bind(mainMiddle.widthProperty().subtract(10));
			text.minWidthProperty().bind(textRoot.widthProperty());
			text.maxWidthProperty().bind(textRoot.widthProperty());

			createDate.minWidthProperty().bind(mainMiddle.widthProperty());
			createDate.maxWidthProperty().bind(mainMiddle.widthProperty());
			editedDate.minWidthProperty().bind(mainMiddle.widthProperty());
			editedDate.maxWidthProperty().bind(mainMiddle.widthProperty());

			appName.setText(msgModel.getAppNameStr().get());
			userImageView.setImage(new Image(msgModel.getUserImageURL().get()));
			if(msgModel.getReUserImageURL().get()!=null)
			{
				reUserImageView.setImage(new Image(msgModel.getReUserImageURL().get()));
			}
			userName.setText(msgModel.getUserNameStr().get());
			userScreenName.setText("@" + msgModel.getUserScreenNameStr().get());
			text.setText(msgModel.getTextStr().get());
			createDate.setText(msgModel.getCreateDateStr().get());
			if(msgModel.getEditedDateStr().get()!=null)
			{
				editedDate.setText(msgModel.getEditedDateStr().get());
			}else{
				editedDate.setText("");
			}
			favCount.setText(msgModel.getFavCountInt().toString());
			repostCount.setText(msgModel.getRepostCountInt().toString());
			spreadCount.setText(msgModel.getSpreadCountInt().toString());

			appIconView.setImage(new Image("twgitter/assets/socialIcons/"+ msgModel.getAppIconP().get() + ".png",16,16,false,true));

			setGraphic(out);
		}
	}

	@SuppressWarnings("unused")
	private Hyperlink createTagLink(String screenName)
	{
		Hyperlink hyperlink = new Hyperlink(screenName);
		hyperlink.setTextFill(Color.GRAY);
		return hyperlink;
	}
}
