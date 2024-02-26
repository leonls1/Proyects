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
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author leon
 */
public class UserUpdateController implements Initializable {


    @FXML
    private Button btnSave, btnAllUsers, btnMenu, btnPayments;
    
    @FXML
    private TextField txtFName, txtFSurname;
    
    @FXML
    private Spinner spnID;
    
    @FXML
    private void btnEvent(ActionEvent event){        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
