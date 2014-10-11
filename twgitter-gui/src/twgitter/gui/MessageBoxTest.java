package twgitter.gui;

import java.io.IOException;
import java.text.ParseException;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import twgitter.config.LoadProperties;
import twgitter.config.OtherConfig;

public class MessageBoxTest extends Application {
	public static void main(String[] args) throws Exception{
		Application.launch(args);
	}
	public static void main() throws Exception{
		String[] args = {""};
		Application.launch(args);
	}

	@Override
	public void start(Stage stage) throws InterruptedException, ParseException, IOException {
		OtherConfig otherCfg = LoadProperties.loadOtherConfig();

		VBox message = MessageBox.makeMessageBox(null,otherCfg);
		Scene scene = new Scene(message);

		message.minWidthProperty().setValue(300);
		message.maxWidthProperty().setValue(300);

		//ScenicView.show(scene);

		Image icon = new Image("twgitter/assets/icon.png");

		// Stageの設定
        stage.getIcons().add(icon);
		stage.setTitle("Twgitter - MsgBoxTest");
		stage.setScene(scene);
		stage.setWidth(300);
		stage.setWidth(message.getMinHeight());
		stage.show();
	}

	@Override
	public void stop()
	{

	}
}
