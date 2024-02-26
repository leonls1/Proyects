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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

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
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
