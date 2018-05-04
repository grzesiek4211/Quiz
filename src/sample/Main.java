package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCombination;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        Parent TextClosedQuestion = FXMLLoader.load(getClass().getResource("TextClosedQuestion.fxml"));
        Parent TextWithPictureClosedQuestion = FXMLLoader.load(getClass().getResource("TextWithPictureClosedQuestion.fxml"));
        Parent TextOpenQuestion = FXMLLoader.load(getClass().getResource("TextOpenQuestion.fxml"));
        Parent TextWithPictureOpenQuestion = FXMLLoader.load(getClass().getResource("TextWithPictureOpenQuestion.fxml"));
        Parent Results = FXMLLoader.load(getClass().getResource("Results.fxml"));
        primaryStage.setTitle("PetroTurniej");
        //primaryStage.setScene(new Scene(root));

        //primaryStage.setScene(new Scene(TextWithPictureClosedQuestion));
        //primaryStage.setScene(new Scene(TextWithPictureOpenQuestion));
        primaryStage.setScene(new Scene(Results));
        primaryStage.setFullScreen(true);
        primaryStage.setFullScreenExitHint("");
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
