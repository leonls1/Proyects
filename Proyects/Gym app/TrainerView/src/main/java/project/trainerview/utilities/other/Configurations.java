package project.trainerview.utilities.other;

import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class Configurations {

    public static void configSpinner_Int(int minValue, int maxValue, int initalValue, Spinner spn) {
        SpinnerValueFactory spinnerValueFactory
                = new SpinnerValueFactory.IntegerSpinnerValueFactory(minValue, maxValue, initalValue);

        spn.setValueFactory(spinnerValueFactory);
    }

    public static void txtOnlyNumbers(TextField txtf) {
        txtf.textProperty().addListener((observale, oldValue, newValue) -> {
            if(!newValue.matches("\\d*")){//observig if the new value added isn't a digit
                txtf.setText(newValue.replaceAll("[^\\d]", "")); //if it isn't a number is replaced with ""
                showAlert("Error", "solo se permiten numeros");//spanish alert version
            }
            
        });
    }        
      
    public static void showAlert(String title, String message ){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
    
    public static void loadTable(TableView table, ObservableList list){
        table.setItems(list);
    }
    
    public static void setColumnView(TableColumn col,String prop){
        col.setCellValueFactory( new PropertyValueFactory<>(prop));
    }
    
}
