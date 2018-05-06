package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class NewScene {
    /*Parent TextClosedQuestion;
    Parent TextWithPictureClosedQuestion;
    Parent TextOpenQuestion;
    Parent TextWithPictureOpenQuestion;
    Parent Results;
    public NewScene(){
        try {
            TextClosedQuestion = FXMLLoader.load(getClass().getResource("/TextClosedQuestion.fxml"));
            TextWithPictureClosedQuestion = FXMLLoader.load(getClass().getResource("/TextWithPictureClosedQuestion.fxml"));
            TextOpenQuestion = FXMLLoader.load(getClass().getResource("/TextOpenQuestion.fxml"));
            TextWithPictureOpenQuestion = FXMLLoader.load(getClass().getResource("/TextWithPictureOpenQuestion.fxml"));
            Results = FXMLLoader.load(getClass().getResource("/Results.fxml"));
        }catch (IOException io) {
            io.printStackTrace();
        }
    }*/

    public void setScene(MouseEvent mouseEvent, long type)
    {
        try {
            Stage stage = (Stage)((Node)mouseEvent.getSource()).getScene().getWindow();

            if (Main.questions.size() <= Main.counterQuestion)
            {
                Parent Results = FXMLLoader.load(getClass().getResource("/Results.fxml"));
                stage.setScene(new Scene(Results));
            }
            else if (type == 0)
            {
                Parent TextClosedQuestion = FXMLLoader.load(getClass().getResource("/TextClosedQuestion.fxml"));
                stage.setScene(new Scene(TextClosedQuestion));
            }
            else if (type == 1)
            {
                Parent TextWithPictureClosedQuestion = FXMLLoader.load(getClass().getResource("/TextWithPictureClosedQuestion.fxml"));
                stage.setScene(new Scene(TextWithPictureClosedQuestion));
            }
            else if (type == 2)
            {
                Parent TextOpenQuestion = FXMLLoader.load(getClass().getResource("/TextOpenQuestion.fxml"));
                stage.setScene(new Scene(TextOpenQuestion));
            }
            else if (type == 3)
            {
                Parent TextWithPictureOpenQuestion = FXMLLoader.load(getClass().getResource("/TextWithPictureOpenQuestion.fxml"));
                stage.setScene(new Scene(TextWithPictureOpenQuestion));
            }

            stage.setFullScreen(true);
            stage.setFullScreenExitHint("");
        }catch (IOException io){
            io.printStackTrace();
        }
    }

    public void setScene(ActionEvent actionEvent, long type)
    {
        try {
            Stage stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();

            if (Main.questions.size() <= Main.counterQuestion)
            {
                Parent Results = FXMLLoader.load(getClass().getResource("/Results.fxml"));
                stage.setScene(new Scene(Results));
            }
            else if (type == 0)
            {
                Parent TextClosedQuestion = FXMLLoader.load(getClass().getResource("/TextClosedQuestion.fxml"));
                stage.setScene(new Scene(TextClosedQuestion));
            }
            else if (type == 1)
            {
                Parent TextWithPictureClosedQuestion = FXMLLoader.load(getClass().getResource("/TextWithPictureClosedQuestion.fxml"));
                stage.setScene(new Scene(TextWithPictureClosedQuestion));
            }
            else if (type == 2)
            {
                Parent TextOpenQuestion = FXMLLoader.load(getClass().getResource("/TextOpenQuestion.fxml"));
                stage.setScene(new Scene(TextOpenQuestion));
            }
            else if (type == 3)
            {
                Parent TextWithPictureOpenQuestion = FXMLLoader.load(getClass().getResource("/TextWithPictureOpenQuestion.fxml"));
                stage.setScene(new Scene(TextWithPictureOpenQuestion));
            }

            stage.setFullScreen(true);
            stage.setFullScreenExitHint("");
        }catch (IOException io){
            io.printStackTrace();
        }
    }
}
