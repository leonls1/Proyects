package project.trainerview.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;
import project.trainerview.App;


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
        Object evt = event.getSource();
        
        if(evt.equals(btnMenu)){
            try {
                App.setRoot("Menu", 340, 270);
            } catch (IOException e) {
                
            }
        }else if(evt.equals(bntCreate)){
            
        }
        
    }
    
    

    @Override
    public void initialize(URL location, ResourceBundle resources) {
   }

}
