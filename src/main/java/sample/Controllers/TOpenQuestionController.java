package sample.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import sample.CountTime;
import sample.Main;
import sample.NewScene;

import java.util.Map;

public class TOpenQuestionController {

    @FXML
    public Label labelTime;
    @FXML
    public Button buttonDobrze;
    @FXML
    public Label labelDescription;
    @FXML
    public Button buttonZle;

    public Map question;

    public CountTime countTime;



    Long time;

    public TOpenQuestionController() {}

    public void initialize()
    {
        question = ((Map)Main.questions.get(Main.counterQuestion));
        time = (Long)question.get("time");
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

    public void OnActionDobrze(ActionEvent actionEvent) {
        question = ((Map)Main.questions.get(Main.counterQuestion));
        Main.counterQuestion++;
        if (Main.questions.size() > Main.counterQuestion) question = ((Map)Main.questions.get(Main.counterQuestion));
        System.out.println((Long)question.get("type"));
        //new NewScene().setScene(actionEvent, (Long)question.get("type"));
        Main.ns.setScene(actionEvent, (Long)question.get("type"));
    }

    public void OnActionZle(ActionEvent actionEvent) {
        question = ((Map)Main.questions.get(Main.counterQuestion));
        new NewScene().setScene(actionEvent, (Long)question.get("type"));
    }

    public void OnActionWynik(ActionEvent actionEvent) {
    }
}
