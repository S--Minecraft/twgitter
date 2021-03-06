package twgitter.gui;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class Main extends Application {
	private VBox vbox;
    private Scene scene;

    private TextArea textArea;
    private TextField commandField;
    private Button commandButton;
    private HBox commandArea;

	public static void main(String[] args){
	    Application.launch(args);
	  }

	@Override
	public void start(Stage stage) {
		// シーングラフとルートオブジェクトの生成
        vbox = new VBox();
        scene = new Scene(vbox);

        // テキストエリア、テキストフィールド、ボタンの設定
        textArea = new TextArea();
        commandField = new TextField();
        commandButton = new Button("Command");
        commandArea = new HBox();

        // テキストエリアとコマンドフィールドの大きさをSceneの大きさに合わせて変更するようにする
        textArea.minHeightProperty().bind(scene.heightProperty().subtract(commandArea.heightProperty()));
        commandField.minWidthProperty().bind(scene.widthProperty().subtract(commandButton.widthProperty()));

        // それぞれのオブジェクトを追加
        commandArea.getChildren().addAll(commandField, commandButton);
        vbox.getChildren().addAll(textArea, commandArea);

        //コマンドの実行
        commandButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if (commandField.getText().equals("quit"))
                {
                    Platform.exit();
                }else if(commandField.getText().equals("exit"))
                {
                	Platform.exit();
                }
            }
        });

        // Stageの設定
        stage.setScene(scene);
        stage.setTitle("JavaFXMemo");
        stage.setWidth(1024); stage.setHeight(700);
        stage.show();
	}

    @Override
    public void stop(){
        System.out.println("アプリケーションを終了します...");
    }
}
/*
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("First.fxml"));
			Scene scene = new Scene(root,400,600);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);

			Tabs toptab = new Tabs();
			String[] topTabName = {"All","Twitter","App.Net","Croudia","Gitter","IRC","Slack"};
			toptab.init(primaryStage,topTabName,400,600);

			Tabs secondtab = new Tabs();
			String[] secondTabName = {"Messages","Favorites","Re","Reply","Mentions"};
			secondtab.init(primaryStage,secondTabName,400,600);


			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
*/
