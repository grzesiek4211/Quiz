package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import sample.Controllers.MainPgController;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;


public class Main extends Application {

    public static Object obj;
    public static JSONObject json;
    public static JSONArray questions;
    public static JSONArray teams;
    public static int counterQuestion;
    public static int counterTeam;
    public static NewScene ns;

    @Override
    public void start(Stage primaryStage) throws Exception{

        setStaticVariable();


        /*Map question = ((Map)questions.get(0));
        System.out.println("Polecenie zerowego elementu tablicy questions: " + question.get("description"));
        Long ddd =  (Long)question.get("time");
        System.out.println(ddd);
        String test = question.get("description").toString();
        System.out.println(test);
        Map team = ((Map)teams.get(0));
        System.out.println("Nazwa zerowego elementu tablicy teams: " + team.get("name"));*/

        /********************* FXML ***************************/
        Parent MainPage = FXMLLoader.load(getClass().getResource("/MainPage.fxml"));
        /*Parent TextClosedQuestion = FXMLLoader.load(getClass().getResource("/TextClosedQuestion.fxml"));
        Parent TextWithPictureClosedQuestion = FXMLLoader.load(getClass().getResource("/TextWithPictureClosedQuestion.fxml"));
        Parent TextOpenQuestion = FXMLLoader.load(getClass().getResource("/TextOpenQuestion.fxml"));
        Parent TextWithPictureOpenQuestion = FXMLLoader.load(getClass().getResource("/TextWithPictureOpenQuestion.fxml"));
        Parent Results = FXMLLoader.load(getClass().getResource("/Results.fxml"));*/
        primaryStage.setTitle("PetroTurniej");
        primaryStage.setScene(new Scene(MainPage));



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

    public static void setStaticVariable() throws Exception {

        counterQuestion = 0;
        counterTeam = 0;

        obj = new JSONParser().parse(new FileReader("data.json"));
        json = (JSONObject) obj;

        questions = (JSONArray) json.get("questions");
        teams = (JSONArray) json.get("teams");

        ns = new NewScene();
    }

    public static void setPoints(int teamID, int points) throws Exception {
        Map m = new LinkedHashMap(3);
        Map team = ((Map)Main.teams.get(teamID));
        m.put("id", (Long)team.get("id"));
        m.put("name", team.get("name").toString());
        m.put("points", (Long)team.get("points")+points);
        teams.set(teamID, m);
        json.put("teams", teams);

        try {

            FileWriter file = new FileWriter("data.json");
            file.write(json.toJSONString());
            file.flush();
            file.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
