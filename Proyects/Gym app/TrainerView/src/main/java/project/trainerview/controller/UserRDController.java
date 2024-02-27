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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import project.trainerview.App;

/**
 * FXML Controller class
 *
 * @author leon
 */
public class UserRDController implements Initializable {

    @FXML
    private Button  btnSearch, btnMenu, btnDelete, btnEdit;
    
    @FXML
    private TextField txtFSearch;
    
    @FXML
    private TableView tableUsers;
    
    @FXML
    private TableColumn colName, colSurname, colId, colExpirationDate;
    
    @FXML
    private void btnEvent(ActionEvent event){
        Object evt = event.getSource();
        
        if(evt.equals(btnDelete)){
            
        }else if(evt.equals(btnEdit)){
            //getting the user id 
            
            try {
                App.setRoot("UserUpdate");
            } catch (IOException ex) {
                Logger.getLogger(UserRDController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }else if(evt.equals(btnMenu)){
            try {
                App.setRoot("Menu");
            } catch (IOException ex) {
                Logger.getLogger(UserRDController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }else if(evt.equals(btnSearch)){
            
        }
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
