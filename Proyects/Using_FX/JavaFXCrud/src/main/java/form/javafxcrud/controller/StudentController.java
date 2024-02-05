/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package form.javafxcrud.controller;

import form.javafxcrud.data.AppQuery;
import form.javafxcrud.model.Student;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import java.util.Optional;
import javafx.collections.FXCollections;

public class StudentController implements Initializable {
    
    private final AppQuery query = new AppQuery();
    
    @FXML
    public TextField fieldFirstName;
    
    @FXML
    public TextField fieldMiddleName;
    
    @FXML
    public TextField fieldSurname;
    
    @FXML
    public TextField fieldSearch;
    
    @FXML
    public Button btnNew;
    
    @FXML
    public Button btnUpdate;
    
    @FXML
    public Button btnSave;
    
    @FXML
    public Button btnDelete;
    
    @FXML
    public TableView<Student> tableView;
    
    @FXML
    public TableColumn<Student, Integer> colId;
    
    @FXML
    public TableColumn<Student, String> colFirtsName;
    
    @FXML
    public TableColumn<Student, String> colMiddleName;
    
    @FXML
    public TableColumn<Student, String> colSurname;
    
    private Student student;
    
    @FXML
    private void addStudent() {

        //definicion de la ventana emergente
        Dialog<ButtonType> dialog = new Dialog<>();
        dialog.setTitle("Add confirmation");
        dialog.setHeaderText("Do you want to save the student?");
        dialog.initModality(Modality.WINDOW_MODAL);

        //definicion de la etiqueta que tengra la ventana
        Label label = new Label("Name:" + fieldFirstName.getText() + " " + fieldMiddleName.getText());
        dialog.getDialogPane().setContent(label);

        //definicion de los botones ok y cancel
        ButtonType okButton = new ButtonType("OK", ButtonBar.ButtonData.OK_DONE);
        ButtonType cancelButton = new ButtonType("CANCEL", ButtonBar.ButtonData.CANCEL_CLOSE);

        //agregado de los botones al dialog
        dialog.getDialogPane().getButtonTypes().addAll(okButton, cancelButton);
        
        Optional<ButtonType> result = dialog.showAndWait();
        
        if (result.isPresent() && result.get() == okButton) {
            Student stu = new Student(
                    fieldFirstName.getText(),
                    fieldMiddleName.getText(),
                    fieldSurname.getText());
            
            query.addStudent(stu);
            btnUpdate.setDisable(true);
            btnDelete.setDisable(true);
            btnSave.setDisable(true);
            
            getStudents();
            clearFields();
        } else {
            System.out.println("Canceled");
            clearFields();
        }
        
    }
    
    @FXML
    private void updateStudent() {
        
        Dialog<ButtonType> dialog = new Dialog<>();
        dialog.setTitle("Update confirmation");
        dialog.setHeaderText("Do you want to update the student?");
        dialog.initModality(Modality.WINDOW_MODAL);

        //definicion de la etiqueta que tengra la ventana
        Label label = new Label("Name:" + fieldFirstName.getText() + " " + fieldMiddleName.getText());
        dialog.getDialogPane().setContent(label);

        //definicion de los botones ok y cancel
        ButtonType okButton = new ButtonType("OK", ButtonBar.ButtonData.OK_DONE);
        ButtonType cancelButton = new ButtonType("CANCEL", ButtonBar.ButtonData.CANCEL_CLOSE);

        //agregado de los botones al dialog
        dialog.getDialogPane().getButtonTypes().addAll(okButton, cancelButton);
        
        Optional<ButtonType> result = dialog.showAndWait();
        
        if (result.isPresent() && result.get() == okButton) {
            student = tableView.getSelectionModel().getSelectedItem();
            student.setFirstName(fieldFirstName.getText());
            student.setMiddleName(fieldMiddleName.getText());
            student.setSurname(fieldSurname.getText());
            
            query.updateStudent(student);
            clearFields();
            btnUpdate.setDisable(true);
            btnDelete.setDisable(true);
            
            tableView.refresh();
        } else {
            clearFields();
            btnUpdate.setDisable(true);
            btnDelete.setDisable(true);
            
        }
        
    }
    
    @FXML
    private void deleteStudent() {
        Dialog<ButtonType> dialog = new Dialog<>();
        dialog.setTitle("Delete confirmation");
        dialog.setHeaderText("Do you want to remove the student?");
        dialog.initModality(Modality.WINDOW_MODAL);

        //definicion de la etiqueta que tengra la ventana
        Label label = new Label("Name:" + fieldFirstName.getText() + " " + fieldMiddleName.getText());
        dialog.getDialogPane().setContent(label);

        //definicion de los botones ok y cancel
        ButtonType okButton = new ButtonType("OK", ButtonBar.ButtonData.OK_DONE);
        ButtonType cancelButton = new ButtonType("CANCEL", ButtonBar.ButtonData.CANCEL_CLOSE);

        //agregado de los botones al dialog
        dialog.getDialogPane().getButtonTypes().addAll(okButton, cancelButton);
        
        Optional<ButtonType> result = dialog.showAndWait();
        
        if (result.get() == okButton && result.isPresent()) {
            query.removeStudent(tableView.getSelectionModel().getSelectedItem().getId());
            tableView.refresh();
            btnDelete.setDisable(true);
            btnUpdate.setDisable(true);
            
            System.out.println("Student Removed");
        } else {
            
        }
        
    }
    
    @FXML
    private void newStudent() {
        clearFields();
        btnDelete.setDisable(true);
        btnUpdate.setDisable(true);
        btnSave.setDisable(false);
    }
    
    @FXML
    private void mouseClicked(MouseEvent mouseEvent) {
        //Object evt = e.getSource();

        try {
            Student stu = tableView.getSelectionModel().getSelectedItem();
            this.student = stu;
            fieldFirstName.setText(student.getFirstName());
            fieldMiddleName.setText(student.getMiddleName());
            fieldSurname.setText(student.getSurname());
            
            btnDelete.setDisable(false);
            btnUpdate.setDisable(false);
            btnSave.setDisable(true);
            
        } catch (Exception e) {
        }
    }
    
    @FXML
    private void getStudents() {
        ObservableList list = query.getStudents();
        
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colFirtsName.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        colMiddleName.setCellValueFactory(new PropertyValueFactory<>("middleName"));
        colSurname.setCellValueFactory(new PropertyValueFactory<>("surname"));
        
        tableView.setItems(list);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        getStudents();
        fieldSearch.textProperty().addListener((ObservableList, oldValue, newValue) -> {
            filterData(newValue);}
        );
    }
    
    private void clearFields() {
        fieldFirstName.setText("");
        fieldMiddleName.setText("");
        fieldSurname.setText("");
    }
    
    private void filterData(String nameSarched) {
        ObservableList<Student> filterData = FXCollections.observableArrayList();
        ObservableList<Student> list = query.getStudents();

        //recorre todos los elementos y si alguno posee la cadena que se esta buscando 
        list.forEach(stu -> {
            if (stu.getFirstName().toLowerCase().contains(nameSarched.toLowerCase())
                    || stu.getMiddleName().toLowerCase().contains(nameSarched.toLowerCase())
                    || stu.getSurname().toLowerCase().contains(nameSarched.toLowerCase())) {
                filterData.add(stu);
            }
        });
        
        tableView.setItems(filterData);
    }
    
}
