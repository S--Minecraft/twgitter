package twgitter.gui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MessageBoxTest extends Application {
	public static void main(String[] args) throws Exception{
		Application.launch(args);
	}
	public static void main() throws Exception{
		String[] args = {""};
		Application.launch(args);
	}

	@Override
	public void start(Stage stage) throws InterruptedException {
		VBox message = MessageBox.makeMessageBox(null);
		Scene scene = new Scene(message);

		message.minWidthProperty().setValue(300);
		message.maxWidthProperty().setValue(300);

		//ScenicView.show(scene);

		// Stageの設定
		stage.setScene(scene);
		stage.setTitle("Twgitter - MessageBoxTesting...");
		stage.setWidth(300);
		stage.setWidth(message.getMinHeight());
		stage.show();
	}

	@Override
	public void stop()
	{

	}
}
