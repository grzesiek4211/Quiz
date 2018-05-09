package sample.Controllers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import sample.CountTime;
import sample.Main;
import sample.NewScene;

import java.io.File;
import java.io.IOException;
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
    @FXML
    public Button buttonWynik;
    @FXML
    public Label nameTeam;
    @FXML
    public ImageView image;

    public Map question;
    public Map team;

    public CountTime countTime;

    static public int A = 0;


    Long time;

    public TOpenQuestionController() {}

    public void initialize()
    {
        question = ((Map)Main.questions.get(Main.counterQuestion));
        team = ((Map)Main.teams.get(Main.counterTeam));
        if((Long)question.get("type") == 3) {
            File file = new File(question.get("picture").toString());
            Image picture = new Image(file.toURI().toString());
            image.setImage(picture);
        }
        time = (Long)question.get("time");
        labelTime.setText(time.toString());
        nameTeam.setText(team.get("name").toString());
        countTime = new CountTime(labelTime, time);
        labelDescription.setText(question.get("description").toString());
        countTime.start();

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

    public void OnActionDobrze(ActionEvent actionEvent) throws Exception {
        question = ((Map)Main.questions.get(Main.counterQuestion));
        System.out.println(A);
        int pk= 10+A*5;
        System.out.println(pk);
        Main.setPoints(Main.counterTeam, pk);
        A=0;
        Main.counterQuestion++;
        Main.counterTeam++;
        if(Main.teams.size() <= Main.counterTeam) Main.counterTeam = 0;
        if (Main.questions.size() > Main.counterQuestion) question = ((Map)Main.questions.get(Main.counterQuestion));
        //System.out.println((Long)question.get("type"));
        //new NewScene().setScene(actionEvent, (Long)question.get("type"));
        Main.ns.setScene(actionEvent, (Long)question.get("type"));
    }

    public void OnActionZle(ActionEvent actionEvent) {
        Main.counterTeam++;
        A++;
        if(Main.teams.size() <= Main.counterTeam) Main.counterTeam = 0;
        question = ((Map)Main.questions.get(Main.counterQuestion));
        new NewScene().setScene(actionEvent, (Long)question.get("type"));
    }

    public void OnActionWynik(ActionEvent actionEvent) {
        buttonWynik.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                try {
                    Parent Results = FXMLLoader.load(getClass().getResource("/Results.fxml"));
                    Stage stage = new Stage();
                    stage.setTitle("Aktualne wyniki");
                    stage.setScene(new Scene(Results, 450, 450));
                    stage.show();
                    stage.setFullScreen(true);
                    stage.setFullScreenExitHint("");
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
