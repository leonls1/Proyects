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
import javafx.scene.control.Spinner;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

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
    private Button bntAddExercice, btnMenu, btnDeleteRutine, btnSaveRutine;
    
    @FXML
    private TableView tableRutine;
    
    @FXML
    private TableColumn colExercice, colRepetitions, colSeries, colDay;
    
    @FXML
    private void btnEvent(ActionEvent event){        
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
