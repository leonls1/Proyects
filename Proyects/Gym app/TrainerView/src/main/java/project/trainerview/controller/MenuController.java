/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package project.trainerview.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

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
            
    }
            
    @Override 
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
