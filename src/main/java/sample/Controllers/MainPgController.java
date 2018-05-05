package sample.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import sample.Main;
import sample.NewScene;

import java.io.IOException;
import java.util.Map;

public class MainPgController {

    @FXML
    private Button startButton;
    public MainPgController()
    {}



    public void initialize()
    {

    }

    public void onActionStartButton(ActionEvent actionEvent) {

        Map question = ((Map)Main.questions.get(Main.counterQuestion));
        new NewScene().setScene(actionEvent, (Long)question.get("type"));

    }
}
