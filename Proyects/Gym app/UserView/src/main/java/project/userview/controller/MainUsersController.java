package project.userview.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class MainUsersController implements Initializable {

    @FXML
    private Label lblNameSurna, lblExpirationDate;

    @FXML
    private TableView tableRutine;

    @FXML
    private TableColumn colExercice, colRepetitions, colSeries, colDay;

    @FXML
    private void btnEvent(ActionEvent event) {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
     
    }

}
