package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.util.Map;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        Object obj = new JSONParser().parse(new FileReader("data.json"));
        JSONObject json = (JSONObject) obj;

        JSONArray questions = (JSONArray) json.get("questions");
        JSONArray teams = (JSONArray) json.get("teams");
        Map question = ((Map)questions.get(0));
        System.out.println("Polecenie zerowego elementu tablicy questions: " + question.get("description"));
        Map team = ((Map)teams.get(0));
        System.out.println("Nazwa zerowego elementu tablicy teams: " + team.get("name"));


        Parent root = FXMLLoader.load(getClass().getResource("/sample.fxml"));
        Parent TextClosedQuestion = FXMLLoader.load(getClass().getResource("/TextClosedQuestion.fxml"));
        Parent TextWithPictureClosedQuestion = FXMLLoader.load(getClass().getResource("/TextWithPictureClosedQuestion.fxml"));
        Parent TextOpenQuestion = FXMLLoader.load(getClass().getResource("/TextOpenQuestion.fxml"));
        Parent TextWithPictureOpenQuestion = FXMLLoader.load(getClass().getResource("/TextWithPictureOpenQuestion.fxml"));
        Parent Results = FXMLLoader.load(getClass().getResource("/Results.fxml"));
        primaryStage.setTitle("PetroTurniej");
        primaryStage.setScene(new Scene(root));

        //primaryStage.setScene(new Scene(TextWithPictureClosedQuestion));
        //primaryStage.setScene(new Scene(TextWithPictureOpenQuestion));
        //primaryStage.setScene(new Scene(TextOpenQuestion));
        //primaryStage.setScene(new Scene(TextWithPictureClosedQuestion));
        //primaryStage.setScene(new Scene(TextClosedQuestion));
        //primaryStage.setScene(new Scene(Results));
        primaryStage.setFullScreen(true);
        primaryStage.setFullScreenExitHint("");
        primaryStage.show();



    }


    public static void main(String[] args) {
        launch(args);
    }
}
