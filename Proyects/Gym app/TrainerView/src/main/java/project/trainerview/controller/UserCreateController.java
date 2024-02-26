package project.trainerview.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;


public class UserCreateController implements Initializable{
    
    @FXML
    private Button bntCreate, btnMenu;
    
    @FXML
    private TextField txtFName, txtFSurname;
    
    @FXML
    private DatePicker dtpExpirationFee;
    
    @FXML
    private Spinner spnId;
    
    @FXML
    private void btnEvent(ActionEvent event){
        
    }
    
    

    @Override
    public void initialize(URL location, ResourceBundle resources) {
   }

}
