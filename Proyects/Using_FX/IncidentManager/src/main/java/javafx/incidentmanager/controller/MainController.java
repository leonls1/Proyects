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
        Object evt = event.getSource();
        
        if(evt.equals(btnLogInCustomer)){
            
        }else if(evt.equals(btnSaveIncident)){
            
        }else if(evt.equals(btnSearchTech)){
            
        }
    }
    
    @FXML
    private void cboAction(ActionEvent event){
        Object evt = event.getSource();
        
        if(evt.equals(cboAvaliablesTechnicians)){
            
        }else if(evt.equals(cboProblemType)){
            
        }else if(evt.equals(cboServices)){
            
        }
    }
    
    
    

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    
    }
   
}
