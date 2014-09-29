package twgitter.gui;

import java.io.IOException;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.util.Duration;

public class StreamTest extends Application {
	  public static void main(String[] args) { launch(args); }
	  @Override public void start(Stage stage) throws IOException {
	    stage.setScene(new Scene(new Stream(), 400, 500));
	    stage.show();
	  }
	}

	/**
	 * Creates a digital clock display as a simple label.
	 * Format of the clock display is hh:mm:ss aa, where:
	 * hh Hour in am/pm (1-12)
	 * mm Minute in hour
	 * ss Second in minute
	 * aa Am/pm marker
	 * Time is the system time for the local timezone.
	 */
	class Stream extends Label {
	  public Stream() {
	    bindUpdate();
	  }

	  // the digital clock updates once a second.
	  private void bindUpdate() {
	    Timeline timeline = new Timeline(
	      new KeyFrame(Duration.seconds(0),
	        new EventHandler<ActionEvent>() {
	          @Override public void handle(ActionEvent actionEvent) {
	            setText("");
	          }
	        }
	      ),
	      new KeyFrame(Duration.seconds(1))
	    );
	    timeline.setCycleCount(Animation.INDEFINITE);
	    timeline.play();
	  }
	}