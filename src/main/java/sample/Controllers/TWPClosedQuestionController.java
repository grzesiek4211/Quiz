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

public class TWPClosedQuestionController {

    @FXML
    public Button buttonB;
    @FXML
    public Button buttonD;
    @FXML
    public Button buttonC;
    @FXML
    public Label labelTime;
    @FXML
    public Label labelDescription;
    @FXML
    public Button buttonA;
    @FXML
    public ImageView image;
    @FXML
    public Label nameTeam;

    public Map question;
    public Map team;

    public CountTime countTime;


    Long time;


    public void initialize()
    {
        question = ((Map)Main.questions.get(Main.counterQuestion));
        team = ((Map)Main.teams.get(Main.counterTeam));
        nameTeam.setText(team.get("name").toString());
        //Main.counterQuestion++;
        buttonA.setText(question.get("answerA").toString());
        buttonB.setText(question.get("answerB").toString());
        buttonC.setText(question.get("answerC").toString());
        buttonD.setText(question.get("answerD").toString());
        File file = new File("../../../../../../images/ropa1.jpg");
        Image picture = new Image(file.toURI().toString());
        image.setImage(picture);
        time = (Long)question.get("time");
        labelTime.setText(time.toString());
        countTime = new CountTime(labelTime, time);
        labelDescription.setText(question.get("description").toString());
        countTime.start();

    }
    public TWPClosedQuestionController() {}

    public void OnActionButtonA(ActionEvent actionEvent) throws Exception {
        setButtons("answerA", "answerB", "answerC", "answerD", buttonA, buttonB, buttonC, buttonD);
    }

    public void OnActionButtonB(ActionEvent actionEvent) throws Exception {
        setButtons("answerB", "answerA", "answerC", "answerD", buttonB, buttonA, buttonC, buttonD);
    }


    public void OnActionButtonC(ActionEvent actionEvent) throws Exception {
        setButtons("answerC", "answerB", "answerA", "answerD", buttonC, buttonB, buttonA, buttonD);
    }

    public void OnActionButtonD(ActionEvent actionEvent) throws Exception {
        setButtons("answerD", "answerB", "answerC", "answerA", buttonD, buttonB, buttonC, buttonA);
    }

    public void OnMouseClicked(MouseEvent mouseEvent) {
        question = ((Map)Main.questions.get(Main.counterQuestion));
        Main.counterQuestion++;
        Main.counterTeam++;
        if(Main.teams.size() <= Main.counterTeam) Main.counterTeam = 0;
        if (Main.questions.size() > Main.counterQuestion) question = ((Map)Main.questions.get(Main.counterQuestion));
        System.out.println((Long)question.get("type"));
        new NewScene().setScene(mouseEvent, (Long)question.get("type"));
    }

    public void setButtons(String clicked_answer, String a2, String a3, String a4, Button clicked, Button b2, Button b3, Button b4) throws Exception {
        countTime.seconds = 0l;
        if(question.get(clicked_answer).toString().equals(question.get("correctAnswer").toString())){
            clicked.setStyle("-fx-background-color: #4CAF50"); //green
            Main.setPoints(Main.counterTeam, 1);
        }
        else if (question.get(a2).toString().equals(question.get("correctAnswer").toString()))
        {
            clicked.setStyle("-fx-background-color: #f44336"); //red
            b2.setStyle("-fx-background-color: #4CAF50"); //green
        }
        else if (question.get(a3).toString().equals(question.get("correctAnswer").toString()))
        {
            clicked.setStyle("-fx-background-color: #f44336"); //red
            b3.setStyle("-fx-background-color: #4CAF50"); //green
        }
        else if (question.get(a4).toString().equals(question.get("correctAnswer").toString()))
        {
            clicked.setStyle("-fx-background-color: #f44336"); //red
            b4.setStyle("-fx-background-color: #4CAF50"); //green
        }
    }
}

