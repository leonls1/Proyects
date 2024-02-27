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
import project.trainerview.App;

/**
 * FXML Controller class
 *
 * @author leon
 */
public class MenuController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML 
    private Button btnCreateUser, btnCreateRutine, btnAllUsers, btnPayments;
    
    @FXML
    private void  btnEvent(ActionEvent event){
        Object evt = event.getSource();
        
        if(evt.equals(btnAllUsers)){
            try {
                App.setRoot("UserRD",620,440);
            } catch (IOException ex) {
                Logger.getLogger(MenuController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }else if(evt.equals(btnCreateRutine)){
            try {
                App.setRoot("RutineCreate",750,540);
            } catch (IOException ex) {
                Logger.getLogger(MenuController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }else if(evt.equals(btnCreateUser)){
            try {
                App.setRoot("UserCreate",380,280);
            } catch (IOException ex) {
                Logger.getLogger(MenuController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else if(evt.equals(btnPayments)){
            try {
                App.setRoot("PaymentView",565,385);
            } catch (IOException ex) {
                Logger.getLogger(MenuController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
            
    }
            
    @Override 
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
