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
import javafx.scene.control.ComboBox;
import javafx.scene.web.WebView;


/**
 * FXML Controller class
 *
 * @author leon
 */
public class RutineUploadController implements Initializable {

    @FXML
    private Button btnRtuineCreator, btnMenu, btnRutineSave;
    
    @FXML
    //private ViewWeb wvRutine;
    private ComboBox<String> cboUser;
    
    @FXML
    private WebView wvRutine;
    
    @FXML
    private void btnEvent(ActionEvent event){
        
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
