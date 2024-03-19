/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package project.trainerview.controller;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;
import project.trainerview.App;
import project.trainerview.model.entities.User;
import project.trainerview.utilities.converters.UserConverter;
import project.trainerview.utilities.other.Configurations;
import project.trainerview.utilities.other.ConfirmationsValidations;

/**
 * FXML Controller class
 *
 * @author leon
 */
public class PaymentViewController implements Initializable {

    private User user;

    private List<User> list;

    @FXML
    private ComboBox cboUsers;

    @FXML
    private Spinner spnMonths;

    @FXML
    private Button btnLoadPayment, btnMenu, btnFilter;

    @FXML
    private Label lblName, lblSurname, lblId, lblDate;

    @FXML
    private TextField txtFFilter;

    @FXML
    private void cboEvent(ActionEvent evt) {
        if (evt.getSource().equals(cboUsers)) {
            this.user = (User) cboUsers.getSelectionModel().getSelectedItem();
            setLabels();

        }
    }

    @FXML
    private void btnEvent(ActionEvent evt) {
        Object event = evt.getSource();

        if (event.equals(btnMenu)) {
            try {
                App.setRoot("Menu", 340, 270);
            } catch (IOException ex) {
                Logger.getLogger(PaymentViewController.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else if (event.equals(btnLoadPayment)) {
            loadPayment();
            setLabels();

        } else if (event.equals(btnFilter)) {
            cboUsers.setItems(FXCollections.observableArrayList(
                    App.userService.filterUser(txtFFilter.getText())
            ));

        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        list = App.userService.getDao().getAll();

        //setting the cbo
        UserConverter converter = new UserConverter(cboUsers);
        cboUsers.setItems(FXCollections.observableArrayList(list));
        cboUsers.setConverter(converter);

        //set spinner
        Configurations.configSpinner_Int(1, 12, 1, spnMonths);

    }

    private void setLabels() {
        //setting labels
        lblName.setText(user.getName());
        lblSurname.setText(user.getSurname());
        lblDate.setText(user.getExpirationDate().toString());
        lblId.setText(user.getId().toString());
    }

    private void loadPayment() {
        //verify if an user was selected
        if (user != null) {
            if (ConfirmationsValidations.confirnationMessage("Confirmacion", "Confirmar Pago", "Se acreditaran: " + spnMonths.getValue() + " meses al usuario, esta seguro?")) {
                System.out.println(user.getExpirationDate());
                if(user.getExpirationDate().isBefore(LocalDate.now())){
                    this.user.setExpirationDate(LocalDate.now().plusMonths(Long.parseLong(spnMonths.getValue().toString())));
                    
                }else{
                    this.user.setExpirationDate(
                        user.getExpirationDate().plusMonths(Long.parseLong(spnMonths.getValue().toString())));
                }
                

                App.userService.getDao().update(user);
            }
        }else {
            Configurations.showErrorAlert("Error", "No se ha seleccionado ningun usuario");
        }

    }

}
