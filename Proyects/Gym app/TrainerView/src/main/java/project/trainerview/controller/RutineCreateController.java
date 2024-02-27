/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package project.trainerview.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Spinner;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import project.trainerview.App;

/**
 * FXML Controller class
 *
 * @author leon
 */
public class RutineCreateController implements Initializable {

    @FXML
    private TextField txtExercice;

    @FXML
    private Spinner spnRepetitions, spnSeries, spnDay;
    
    @FXML
    private ComboBox cboUser;
    
    @FXML
    private Button btnAddExercice, btnMenu, btnDeleteRutine, btnSaveRutine;
    
    @FXML
    private TableView tableRutine;
    
    @FXML
    private TableColumn colExercice, colRepetitions, colSeries, colDay;
    
    @FXML
    private void btnEvent(ActionEvent event){  
        Object evt = event.getSource();
        
        if(evt.equals(btnMenu)){
            try {
                App.setRoot("Menu");
            } catch (IOException e) {
            }
        }else if(evt.equals(btnDeleteRutine)){
            
        }else if(evt.equals(btnSaveRutine)){
            
        }else if(evt.equals(btnAddExercice)){
            
        }
    }
    
    @FXML
    private void cboEvent(ActionEvent event){        
    }
    
    @FXML
    private void mouseEvent(MouseEvent event){        
    }
            

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
    

}
