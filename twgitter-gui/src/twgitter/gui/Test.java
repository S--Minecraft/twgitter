package twgitter.gui;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Side;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Test extends Application {
	private static TextArea middleLeft = new TextArea();
	//private static VBox middleLeft = new VBox();
	private static ScrollPane middleLeftScrollPane = new ScrollPane();

	public static void main(String[] args) throws Exception{
	    Application.launch(args);
	  }
	public void main() throws Exception{
		String[] args = {""};
	    Application.launch(args);
	  }

	@Override
	public void start(Stage stage) throws InterruptedException {
		// シーングラフとルートオブジェクトの生成
		VBox vbox = new VBox();
		Scene scene = new Scene(vbox);

		HBox top = new HBox();
		HBox middle = new HBox();
		vbox.getChildren().addAll(top,middle);

		VBox left = new VBox();
		VBox right = new VBox();
		BorderPane secondBorderPane = new BorderPane();
		String[] secondTabName = {"Messages","Favorites","Re","Reply","Mentions","PrivateMessages"};
		secondBorderPane = Tabs.makeTab(secondBorderPane, secondTabName, 40, 40,Side.LEFT);
		middle.getChildren().addAll(secondBorderPane,left,right);

		BorderPane topBorder = new BorderPane();
		topBorder.setStyle("-fx-background-color: #a6a6a6");
		Button btnSetting = new Button("*");
		topBorder.setCenter(btnSetting);
		BorderPane firstBorderPane = new BorderPane();
		String[] firstTabName = {"All","Twitter","App.Net","Croudia","Gitter","IRC","Slack"};
		firstBorderPane = Tabs.makeTab(firstBorderPane, firstTabName, 40, 40,Side.TOP);
		top.getChildren().addAll(topBorder,firstBorderPane);

		TextArea middleRight = new TextArea();
		//TextArea middleLeft = new TextArea();
		//final ScrollPane middleLeftScrollPane = new ScrollPane();
		middleLeft.setStyle("-fx-background-color: #CCCCCC");
		//VBox messageBox = MessageBox.makeMessageBox(scene);
		//middleLeft.getChildren().addAll(messageBox);
		VBox middleLeftBack = new VBox();
		middleLeftScrollPane.setContent(middleLeft);
		middleLeftScrollPane.setFitToWidth(true);
		HBox middleBottom = new HBox();
		left.getChildren().addAll(middleLeftBack,middleBottom);
		right.getChildren().addAll(middleRight);
		middleLeftBack.getChildren().addAll(middleLeft);

		TextArea sendArea = new TextArea();
		VBox bottomFunc = new VBox();
		bottomFunc.setStyle("-fx-background-color: #a6a6a6");
		middleBottom.getChildren().addAll(sendArea,bottomFunc);

		Button btnSend = new Button("↑");
		ChoiceBox<String> changeApp = new ChoiceBox<>();
		changeApp.getItems().addAll("Twitter","App.Net","Croudia","Gitter","IRC","Slack");
		changeApp.getSelectionModel().selectFirst();
		bottomFunc.getChildren().addAll(btnSend,changeApp);

		vbox.minHeightProperty().bind(scene.heightProperty());

		top.minHeightProperty().setValue(30);
		top.maxHeightProperty().setValue(30);
		middle.minHeightProperty().bind(scene.heightProperty().subtract(top.heightProperty()));

		secondBorderPane.minWidthProperty().setValue(30);

		topBorder.setPrefSize(30,30);

		firstBorderPane.minWidthProperty().bind(scene.widthProperty().subtract(topBorder.widthProperty()));;

		left.minHeightProperty().bind(scene.heightProperty().subtract(top.heightProperty()));
		left.minWidthProperty().bind(scene.widthProperty().subtract(secondBorderPane.heightProperty()).subtract(right.heightProperty()));
		middleBottom.minHeightProperty().setValue(80);
		middleBottom.maxHeightProperty().setValue(80);
		middleBottom.minWidthProperty().bind(left.widthProperty());
		middleLeft.minHeightProperty().bind(middle.heightProperty().subtract(middleBottom.heightProperty()));
		middleLeft.minWidthProperty().bind(middle.widthProperty().subtract(secondBorderPane.widthProperty()).subtract(right.widthProperty()));;

		btnSend.minWidthProperty().setValue(30);
		btnSend.maxWidthProperty().setValue(30);
		btnSend.minHeightProperty().setValue(30);
		btnSend.maxHeightProperty().setValue(30);
		changeApp.minWidthProperty().setValue(30);
		changeApp.maxWidthProperty().setValue(30);
		changeApp.minHeightProperty().setValue(15);
		changeApp.maxHeightProperty().setValue(15);

		right.minHeightProperty().bind(middle.heightProperty());
		right.minWidthProperty().setValue(150);
		middleRight.minHeightProperty().bind(right.heightProperty());
		middleRight.minWidthProperty().setValue(150);
		middleRight.maxWidthProperty().setValue(150);

		// Stageの設定
		stage.setScene(scene);
		stage.setTitle("Twgitter");
		stage.setWidth(500);
		stage.setHeight(700);

		/*
		middleLeft.textProperty().addListener(new ChangeListener<String>() {
		    public void changed(final ObservableValue<? extends String> observable, final String oldValue, final String newValue) {
	            middleLeftScrollPane.setVvalue(middleLeftScrollPane.getVmax());
		    }
		});
		*/

		stage.show();
	}

	//add textArea to your scene somewhere in the start method
	public static void println(final String s){
		Platform.runLater(new Runnable() {//in case you call from other threadx
			@Override
			public void run() {
				middleLeft.setText(s + "\n" + middleLeft.getText());

				//System.out.println(s);//for echo if you want
				//middleLeftScrollPane.setVvalue(middleLeftScrollPane.getVmax());
				//middleLeftScrollPane.setVvalue(1.0);
			}
		});
	}

	/*
	public static void messageln(final AllMessages msg){
		Platform.runLater(new Runnable() {//in case you call from other threadx
			@Override
			public void run() {
				VBox messageBox = new VBox();
				VBox message = MessageBox.makeMessageBox(msg);
				messageBox.getChildren().add(message);

				//Collection<? extends Node> messages;
				//messages = middleLeft.getChildren();
				//middleLeft.getChildren().clear();
				//middleLeft.getChildren().add(messageBox);
				//middleLeft.getChildren().addAll(messages);
				middleLeft.getChildren().add(messageBox);
			}
		});
	}
	*/

	@Override
	public void stop()
	{

	}
}
