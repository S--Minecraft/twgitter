package twgitter.gui;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class Browser extends Application{
	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage primaryStage) {
		primaryStage.setTitle("Twgitter - Browser");
		Group root = new Group();
		Scene scene = new Scene(root, 800, 600);

		WebView webView = new WebView();
		WebEngine engine = webView.getEngine();
		engine.load("http://maps.google.co.jp/");

		root.getChildren().add(webView);

		primaryStage.setScene(scene);
		primaryStage.show();
	}
}
