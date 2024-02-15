package proyects.rutinegenerator.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class RutineCRUDController implements Initializable {

    @FXML
    private TableView tableRutines,tableRutineDetail;

    @FXML
    private Button btnDelete, btnReturn, btnPrint;
    
    @FXML 
    private TableColumn colName, colDay, colDays;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
