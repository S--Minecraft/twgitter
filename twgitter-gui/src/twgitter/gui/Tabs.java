package twgitter.gui;

import javafx.application.Application;
import javafx.geometry.Side;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Tabs extends Application {
	public static BorderPane makeTab(BorderPane borderPane,String[] tabName,int width,int height,Side side) {
		final TabPane tabPane = new TabPane();

		tabPane.setPrefSize(width,height);
		tabPane.setSide(side);
		tabPane.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);

		Tab[] tabs = new Tab[tabName.length];

		for(int i=0;i<tabName.length;i++)
		{
			tabs[i] = new Tab();
			tabs[i].setText(tabName[i]);

			tabPane.getTabs().add(tabs[i]);
		}

		//tabPane.getTabs().addAll();

		/*
		final Tab tab1 = new Tab();
		tab1.setText("Tab 1");
		final Tab tab2 = new Tab();
		tab2.setText("Tab 2");
		final Tab tab3 = new Tab();
		tab3.setText("Tab 3");
		final Tab tab4 = new Tab();
		tab4.setText("Tab 4");
		*/

		//tabPane.getTabs().addAll(tab1, tab2, tab3, tab4);

		borderPane.setCenter(tabPane);

		return borderPane;
	}

	@Override public void start(Stage primaryStage) throws Exception {
		VBox vbox = new VBox();
		Scene scene = new Scene(vbox);

		String[] tabNames = {"1","2"};
		BorderPane a = new BorderPane();
		a = makeTab(a, tabNames,400,400,Side.TOP);

		vbox.getChildren().add(a);

		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
