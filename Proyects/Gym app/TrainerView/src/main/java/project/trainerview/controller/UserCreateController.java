package project.trainerview.controller;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import project.trainerview.App;
import project.trainerview.model.entities.User;
import project.trainerview.model.persistence.UserDAO;
import project.trainerview.utilities.factories.DAOFactory;
import project.trainerview.utilities.other.Configurations;
import project.trainerview.utilities.other.ConfirmationsValidations;

public class UserCreateController implements Initializable {

    @FXML
    private Button btnCreate, btnMenu;

    @FXML
    private TextField txtFName, txtFSurname, txtFId;

    @FXML
    private DatePicker dtpExpirationFee;

    private UserDAO userService;

    private User user;

    @FXML
    private void btnEvent(ActionEvent event) {
        Object evt = event.getSource();

        if (evt.equals(btnMenu)) {
            try {
                App.setRoot("Menu", 340, 270);
            } catch (IOException e) {

            }
        } else if (evt.equals(btnCreate)) {
            saveUser();
        }

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        userService = DAOFactory.geUserDAO();
        //setting the txtFid to only accept numbers
        Configurations.txtOnlyNumbers(txtFId);
        dtpExpirationFee.setValue(LocalDate.now());

    }

    private void saveUser() {
        if (txtFName.getText().isBlank() || txtFId.getText().isBlank()) {
            Configurations.showAlert("ERROR", "El nombre y DNI no pueden estar vacios");

        } else if (ConfirmationsValidations.confirnationMessage("CONFIRMACION", "crear un nuevo usuario", txtFName.getText() + " " + txtFSurname.getText())) {

            if (userService.existsByid(Long.valueOf(txtFId.getText()))) {
                user = new User();
                user.setExpirationDate(dtpExpirationFee.getValue());
                user.setId(Long.valueOf(txtFId.getText()));
                user.setName(txtFName.getText());
                user.setSurname(txtFSurname.getText());

                System.out.println("Usuario creado");
                userService.create(user);
                
                //reseting the fields
                txtFId.setText("");
                txtFName.setText("");
                txtFSurname.setText("");
                dtpExpirationFee.setValue(LocalDate.now());
            } else {
                Configurations.showAlert("ERROR", "El DNI ingresado ya existe");
            }

        }

    }

}
