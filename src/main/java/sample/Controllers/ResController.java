package sample.Controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import sample.Main;
import sample.Team;

import java.util.Map;
import java.util.Observable;

public class ResController {

    @FXML
    public TableView<Team> table;
    @FXML
    public TableColumn<Team, String> name;
    @FXML
    public TableColumn<Team, Long> points;
    @FXML
    public TableColumn<Team, Long> id;

    public ResController() {}

    public ObservableList<Team> getTeam()
    {
        ObservableList<Team> list = FXCollections.observableArrayList();
        for(int i = 0; i < Main.teams.size(); i++)
        {
            Map team = ((Map)Main.teams.get(i));
            list.add(new Team(team.get("name").toString(), (Long)team.get("points"), (Long)team.get("id")));
        }
        return list;
    }

    public void initialize()
    {
        id.setCellValueFactory(new PropertyValueFactory<Team, Long>("id"));
        points.setCellValueFactory(new PropertyValueFactory<Team, Long>("points"));
        name.setCellValueFactory(new PropertyValueFactory<Team, String>("name"));
        table.setItems(getTeam());
    }



}
