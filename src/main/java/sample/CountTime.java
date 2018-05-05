package sample;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.util.Duration;

public class CountTime {

    public Long seconds;
    public Label label;
    public CountTime(Label label, Long seconds)
    {
        this.label = label;
        this.seconds = seconds;
    }
    Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(1), new EventHandler()
    {
        public void handle(Event event) {
            if(seconds == 0)
            {
                label.setText("Dalej");
                seconds--;
            }
            else if(seconds > 0)
            {
                label.setText(seconds.toString());
                seconds--;
            }
            else
            {
                timeline.stop();
            }
        }

    }));

    public void start(){
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }
}
