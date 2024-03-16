package project.userview.controller;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import project.trainerview.utilities.other.Configurations;
import project.userview.model.entities.SubRutine;
import project.userview.model.entities.User;
import project.userview.service.UserService;

public class MainUsersController implements Initializable {

    private User user;
    private UserService userService;

    @FXML
    private TextField txtFId;

    @FXML
    private Button btnSeeRutine, btnCopyRutine;

    @FXML
    private Label lblNameSurname, lblExpirationDate;

    @FXML
    private TableView<SubRutine> tableRutine;

    @FXML
    private TableColumn colExercice, colRepetitions, colSeries, colDay;

    @FXML
    private void btnEvent(ActionEvent event) {
        Object evt = event.getSource();

        if (evt.equals(btnSeeRutine)) {
            loadUser();
        } else if (evt.equals(btnCopyRutine)) {
            copyTableViewContentToClipboard();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        user = new User();
        userService = new UserService();

        //dni field just acept numbers
        Configurations.txtOnlyNumbers(txtFId);

    }

    //-----------------------------------interface Methods -----------------------//
    private void loadTable() {
        tableRutine.setItems(FXCollections.observableArrayList(user.getRutine().getSubRutines()));

        colDay.setCellValueFactory(new PropertyValueFactory("day"));
        colExercice.setCellValueFactory(new PropertyValueFactory("excercise"));
        colRepetitions.setCellValueFactory(new PropertyValueFactory("repetitions"));
        colSeries.setCellValueFactory(new PropertyValueFactory("series"));
    }

    private void loadUser() {
        //getting the user
        if (!txtFId.getText().isBlank()) {
            user = userService.getDao().getById(Long.valueOf(txtFId.getText()));

            //verify the if user isn't null 
            if (user != null && user.getRutine() != null) {
                lblNameSurname.setText(user.getName() + " " + user.getSurname());

                //checkeing if the rutine isn't empty                
                if (user.getRutine().getSubRutines() != null) {
                    //checking if the payment is up to date
                    if (user.getExpirationDate().isAfter(LocalDate.now())) {
                        lblExpirationDate.setText(user.getExpirationDate().toString());
                        lblExpirationDate.setTextFill(Color.DARKOLIVEGREEN);
                        lblExpirationDate.setFont(new Font(25));
                        loadTable();
                        //is not the table will be blank and changed the text
                    } else {
                        lblExpirationDate.setText("Cuota vencida");
                        lblExpirationDate.setTextFill(Color.ORANGERED);
                        lblExpirationDate.setFont(new Font(40));
                        tableRutine.setItems(FXCollections.observableArrayList());
                    }

                } else {
                    //otherwise the table will be blank
                    tableRutine.setItems(FXCollections.observableArrayList());

                    //repeting the check for user pay
                    //checking if the payment is up to date
                    if (user.getExpirationDate().isAfter(LocalDate.now())) {
                        lblExpirationDate.setText(user.getExpirationDate().toString());
                        lblExpirationDate.setTextFill(Color.DARKOLIVEGREEN);
                        lblExpirationDate.setFont(new Font(25));
                        loadTable();
                        //is not the table will be blank and changed the text
                    } else {
                        lblExpirationDate.setText("Cuota vencida");
                        lblExpirationDate.setTextFill(Color.ORANGERED);
                        lblExpirationDate.setFont(new Font(40));
                        tableRutine.setItems(FXCollections.observableArrayList());
                    }
                }

            } else {
                Configurations.showErrorAlert("No existe", "El usuario con ese dni no existe, o no tiene una rutina asignada");
            }
        }

        txtFId.setText("");

    }

    private void copyTableViewContentToClipboard() {
        // Obtener el contenido de la TableView en formato de texto con formato de tabla
        StringBuilder content = new StringBuilder();

        // Obtener el número de columnas y filas
        int numRows = tableRutine.getItems().size();
        int numCols = tableRutine.getColumns().size();

        // Iterar sobre las filas y columnas para obtener el contenido
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                // Obtener el valor de la celda y agregarlo al contenido con tabulación
                String cellValue = tableRutine.getColumns().get(j).getCellData(i).toString();
                content.append(cellValue);
                if (j < numCols - 1) {
                    content.append("\t"); // Agregar tabulación entre columnas
                }
            }
            content.append("\n"); // Agregar salto de línea al final de cada fila
        }

        // Colocar el contenido en el portapapeles
        Clipboard clipboard = Clipboard.getSystemClipboard();
        ClipboardContent clipboardContent = new ClipboardContent();
        clipboardContent.putString(content.toString());
        clipboard.setContent(clipboardContent);

        Configurations.showInfoAlert("Rutina copiada", "Se ha copiado la rutina al portapapeles");
    }

}
