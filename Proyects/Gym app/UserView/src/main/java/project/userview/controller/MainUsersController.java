package project.userview.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import project.trainerview.utilities.other.Configurations;
import project.userview.model.entities.User;
import project.userview.service.UserService;

public class MainUsersController implements Initializable {

    private User user;
    private UserService userService;

    @FXML
    private TextField txtFId;

    @FXML
    private Button btnSeeRutine;

    @FXML
    private Label lblNameSurname, lblExpirationDate;

    @FXML
    private TableView tableRutine;

    @FXML
    private TableColumn colExercice, colRepetitions, colSeries, colDay;

    @FXML
    private void btnEvent(ActionEvent event) {
        if (event.getSource().equals(btnSeeRutine)) {
            loadUser();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        user = new User();
        userService = new UserService();
        
    }

    //-----------------------------------interface Methods -----------------------//
    private void loadTable() {
        tableRutine.setItems(FXCollections.observableArrayList(user.getRutine().getSubRutines()));

        colDay.setCellValueFactory(new PropertyValueFactory("day"));
        colExercice.setCellValueFactory(new PropertyValueFactory("excercise"));
        colRepetitions.setCellValueFactory(new PropertyValueFactory("repetitions"));
        colSeries.setCellValueFactory(new PropertyValueFactory("series"));
    }

    private void loadUser() {
        //getting the user
        user = userService.getDao().getById(Long.valueOf(txtFId.getText()));

        //verify the if user isn't null 
        if (user != null) {
            lblExpirationDate.setText(user.getExpirationDate().toString());
            lblNameSurname.setText(user.getName() + " " + user.getSurname());
            loadTable();

        } else {
            Configurations.showErrorAlert("No existe", "El usuario con ese dni no existe");
        }
        
        txtFId.setText("");
        
    }

}
