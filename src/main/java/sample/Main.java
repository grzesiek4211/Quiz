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

        /********************* FXML ***************************/
        Parent MainPage = FXMLLoader.load(getClass().getResource("/MainPage.fxml"));
        primaryStage.setTitle("PetroTurniej");
        primaryStage.setScene(new Scene(MainPage));

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
