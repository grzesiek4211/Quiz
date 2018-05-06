package sample.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import sample.CountTime;
import sample.Main;
import sample.NewScene;

import java.io.File;
import java.util.Map;

public class TWPOpenQuestionController {

    @FXML
    public Label labelTime;
    @FXML
    public Button buttonDobrze;
    @FXML
    public Label labelDescription;
    @FXML
    public ImageView image;
    @FXML
    public Button buttonZle;

    public Map question;

    public CountTime countTime;

    Long time;

    public TWPOpenQuestionController() {}

    public void initialize()
    {
        question = ((Map)Main.questions.get(Main.counterQuestion));
        time = (Long)question.get("time");
        File file = new File("../../../../../../images/ropa1.jpg");
        Image picture = new Image(file.toURI().toString());
        image.setImage(picture);
        labelTime.setText(time.toString());
        countTime = new CountTime(labelTime, time);
        labelDescription.setText(question.get("description").toString());
        countTime.start();

    }

    public void OnMouseClicked(MouseEvent mouseEvent) {
        /*Main.counterQuestion++;
        question = ((Map)Main.questions.get(Main.counterQuestion));
        new NewScene().setScene(mouseEvent, (Long)question.get("type"));*/
    }

    public void OnActionButtonZle(ActionEvent actionEvent) {
        question = ((Map)Main.questions.get(Main.counterQuestion));
        new NewScene().setScene(actionEvent, (Long)question.get("type"));
    }

    public void OnActionButtonDobrze(ActionEvent actionEvent) {
        question = ((Map)Main.questions.get(Main.counterQuestion));
        Main.counterQuestion++;
        if (Main.questions.size() > Main.counterQuestion) question = ((Map)Main.questions.get(Main.counterQuestion));
        System.out.println((Long)question.get("type"));
        //new NewScene().setScene(actionEvent, (Long)question.get("type"));
        Main.ns.setScene(actionEvent, (Long)question.get("type"));
    }
}
