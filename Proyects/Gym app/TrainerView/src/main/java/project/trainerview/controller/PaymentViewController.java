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
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import project.trainerview.App;

/**
 * FXML Controller class
 *
 * @author leon
 */
public class PaymentViewController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML
    private ComboBox<String> cboUsers;
    
    @FXML
    private Spinner spnMonths;
    
    @FXML
    private Button btnLoadPayment, btnMenu;
    
    @FXML
    private Label lblName,lblSurname, lblId, lblDate;
    
    @FXML
    private void cboEvent(ActionEvent evt){
        
    }
    
    @FXML
    private void btnEvent(ActionEvent evt){
        Object event = evt.getSource();
        
        if(event.equals(btnMenu)){
            try {
                App.setRoot("Menu");
            } catch (IOException ex) {
                Logger.getLogger(PaymentViewController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }else if(event.equals(btnLoadPayment)){
            
        }
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
