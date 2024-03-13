/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package project.trainerview.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import project.trainerview.App;
import project.trainerview.utilities.other.Configurations;


public class LogInController implements Initializable {


    @FXML
    private Button bntLogIn;

    @FXML
    private PasswordField txtPassword;

    @FXML
    void btnEvent(ActionEvent event) {
        if(event.getSource().equals(bntLogIn)){
            verifyUser();
        }
    } 

    @Override
    public void initialize(URL location, ResourceBundle resources) {
     
    }
    
    private void verifyUser(){
        if(txtPassword.getText().equalsIgnoreCase("DG_77951")){           
             try {
                App.setRoot("Menu", 340, 270);
            } catch (IOException ex) {
                Logger.getLogger(PaymentViewController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            
            Configurations.showErrorAlert("Eror", "Contraseña Invalida");
        }
    }
    
}
