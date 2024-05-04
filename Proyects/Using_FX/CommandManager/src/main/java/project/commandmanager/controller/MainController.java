/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package project.commandmanager.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Spinner;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author leon
 */
public class MainController implements Initializable {

   
    @FXML
    private Button btnAddItem;

    @FXML
    private Button btnCancel;

    @FXML
    private Button btnConfirm;

    @FXML
    private ComboBox<?> cboElements;

    @FXML
    private ComboBox<?> cboPaymentType;

    @FXML
    private ComboBox<?> cboStreet;

    @FXML
    private ComboBox<?> cboType;

    @FXML
    private TableColumn<?, ?> colElement;

    @FXML
    private TableColumn<?, ?> colQuantity;

    @FXML
    private TableColumn<?, ?> colSubTotal;

    @FXML
    private TableColumn<?, ?> colUnitPrice;

    @FXML
    private Spinner<?> spnQuantity;

    @FXML
    private TableView<?> table;

    @FXML
    private TextArea txtADetails;

    @FXML
    private Text txtAmount;

    @FXML
    private TextField txtNumber;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
