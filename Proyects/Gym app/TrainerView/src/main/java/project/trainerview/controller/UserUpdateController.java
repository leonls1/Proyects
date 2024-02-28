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
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;
import project.trainerview.App;

/**
 * FXML Controller class
 *
 * @author leon
 */
public class UserUpdateController implements Initializable {


    @FXML
    private Button btnSave, btnAllUsers, btnMenu, btnPayments;
    
    @FXML
    private TextField txtFName, txtFSurname, txtFId;
    

    
    @FXML
    private void btnEvent(ActionEvent event){        
        Object evt = event.getSource();
        
        if(evt.equals(btnAllUsers)){
            try {
                App.setRoot("UserRD", 620, 440);
            } catch (IOException ex) {
                Logger.getLogger(UserUpdateController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }else if(evt.equals(btnMenu)){
            try {
                App.setRoot("Menu",270, 340);
            } catch (IOException ex) {
                Logger.getLogger(UserUpdateController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }else if(evt.equals(btnPayments)){
            try {
                App.setRoot("PaymentView", 565, 385);
            } catch (IOException ex) {
                Logger.getLogger(UserUpdateController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }else if(evt.equals(btnSave)){
            
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public UserUpdateController(Long id) {
    }

    public UserUpdateController() {
    }
    
    
    
    

    
    
}
