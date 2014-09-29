package twgitter.gui;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.geometry.Bounds;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class LabelTest extends Application{
	public static void main(String[] args){
		Application.launch(args);
	}

	@Override
    public void start(Stage primaryStage) {

        final Label txt = new Label("Example");
        txt.relocate(100, 100);

        Pane root = new Pane();

        final Rectangle border = new Rectangle();
        border.setFill(Color.TRANSPARENT);
        border.setStroke(Color.RED);

        // here we autoupdate border
        txt.boundsInParentProperty().addListener(new ChangeListener<Bounds>() {

            @Override
            public void changed(ObservableValue<? extends Bounds> ov, Bounds old, Bounds b) {
                border.setX(b.getMinX() - 1);
                border.setY(b.getMinY() - 1);
                border.setWidth(b.getWidth()+2);
                border.setHeight(b.getHeight()+2);
            }
        });

        root.getChildren().addAll(txt, border);

        // click to see automatic border reaction
        root.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent t) {
                txt.relocate(Math.random()*200, Math.random()*200);
                txt.setText(Math.random() + "");
            }
        });
        Scene scene = new Scene(root, 300, 250);

        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
