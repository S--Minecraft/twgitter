package twgitter.gui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import com.javafx.experiments.scenicview.ScenicView;

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
		MessageBox a = new MessageBox();
		VBox message = a.makeMessageBox(null);
		Scene scene = new Scene(message);

		//vbox.minHeightProperty().bind(scene.heightProperty());
		//vbox.minWidthProperty().setValue(300);
		//vbox.maxWidthProperty().setValue(300);
		//message.minHeightProperty().bind(scene.heightProperty());
		//message.minWidthProperty().setValue(300);
		//message.maxWidthProperty().setValue(300);

		ScenicView.show(scene);

		// Stageの設定
		stage.setScene(scene);
		stage.setTitle("Twgitter - MessageBoxTesting...");
		stage.setWidth(300);
		stage.setHeight(200);
		stage.show();
	}

	@Override
	public void stop()
	{

	}
}
