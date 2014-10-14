package twgitter.gui.message;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.util.Callback;
import twgitter.config.LoadProperties;
import twgitter.config.OtherConfig;

public class MessageCellTest extends Application{
	public static OtherConfig otherConfig;
	private static ListView<MessageModel> listView;
	private static ObservableList<MessageModel> msgModels;

	public static void main(String[] args) throws Exception{
		Application.launch(args);
	}
	public static void main() throws Exception{
		String[] args = {""};
		Application.launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		OtherConfig otherCfg = LoadProperties.loadOtherConfig();
		otherConfig = otherCfg;

		msgModels = FXCollections.observableArrayList();
		listView = new ListView<MessageModel>();
		//listView.setCellFactory(param -> new MessageCell());
		listView.setCellFactory(new Callback(){
			@Override
			public Object call(Object param) {
				return new MessageCell();
			}
		});
		Scene scene = new Scene(listView);

		listView.minWidthProperty().setValue(300);
		listView.maxWidthProperty().setValue(300);

		//ScenicView.show(scene);

		Image icon = new Image("twgitter/assets/icon.png");

		// Stageの設定
        stage.getIcons().add(icon);
		stage.setTitle("Twgitter - MsgCellTest");
		stage.setScene(scene);
		stage.setWidth(300);
		stage.setWidth(listView.getMinHeight());
		stage.show();
	}

	public static void listAdd(final MessageModel msgModel){
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				//ObservableList<MessageModel> bMsgModels = msgModels;
				//msgModels.clear();
				//msgModels.add(msgModel);
				//msgModels.addAll(bMsgModels);
				msgModels.add(msgModel);

				listView.setItems(msgModels);
			}
		});
	}
}
