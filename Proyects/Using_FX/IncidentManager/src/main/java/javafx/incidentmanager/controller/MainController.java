package javafx.incidentmanager.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class MainController implements Initializable{

    @FXML
    private Button btnLogInCustomer, btnSaveIncident, btnSearchTech;
    
    @FXML
    private TextField txtFCorporateName, txtfCUIL;
    
    @FXML
    private TextArea txtADescription;
    
    @FXML 
    private ComboBox<String> cboServices,cboProblemType, cboAvaliablesTechnicians;
    
    @FXML 
    private void  btnAction(ActionEvent event){
        
    }
    
    @FXML
    private void cboAction(ActionEvent event){
        
    }
    
    
    

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    
    }
   
}
