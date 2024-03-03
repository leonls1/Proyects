/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package project.trainerview.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import project.trainerview.App;
import project.trainerview.model.entities.Rutine;
import project.trainerview.model.entities.SubRutine;
import project.trainerview.model.entities.User;
import project.trainerview.model.persistence.RutineDAO;
import project.trainerview.model.persistence.UserDAO;
import project.trainerview.utilities.factories.DAOFactory;
import project.trainerview.utilities.other.Configurations;

/**
 * FXML Controller class
 *
 * @author leon
 */
public class RutineCreateController implements Initializable {

    private Rutine rutine;

    private RutineDAO rutineService;

    private List<SubRutine> list;

    private SubRutine subRutine;

    private User user;

    private UserDAO userService;

    @FXML
    private TextField txtFExercice, txtFReps;

    @FXML
    private Spinner spnSeries, spnDay;

    @FXML
    private ComboBox cboUser;

    @FXML
    private Button btnAddExercice, btnMenu, btnDeleteSubRutine, btnSaveRutine, btnEditExcercise;

    @FXML
    private TableView tableRutine;

    @FXML
    private TableColumn colExercice, colRepetitions, colSeries, colDay;

    @FXML
    private void btnEvent(ActionEvent event) {
        Object evt = event.getSource();

        if (evt.equals(btnMenu)) {
            try {
                App.setRoot("Menu", 340, 270);
            } catch (IOException e) {
            }
        } else if (evt.equals(btnDeleteSubRutine)) {
            deleteSubRutine();

        } else if (evt.equals(btnSaveRutine)) {

        } else if (evt.equals(btnAddExercice)) {
            addSubrutine();
        } else if (evt.equals(btnEditExcercise)) {

        }
    }

    @FXML
    private void cboEvent(ActionEvent event) {
    }

    @FXML
    private void mouseEvent(MouseEvent event) {
        if (event.getSource().equals(tableRutine)) {
            getSubrutine();

        }

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Configurations.configSpinner_Int(1, 6, 3, spnDay);
        Configurations.configSpinner_Int(1, 10, 3, spnSeries);
        rutine = new Rutine();
        list = new ArrayList<>();
        rutineService = DAOFactory.geRutineDAO();
        userService = DAOFactory.geUserDAO();
        
        cboUser.setItems(FXCollections.observableArrayList(List.of("Usuario 1","Usuario 2", "Usuario 3 ", "... Usuario N")));
    }

    //------------------------------Interface Methods----------------------------//
    public void loadTable(List<SubRutine> list) {
        tableRutine.setItems(FXCollections.observableArrayList(list));

        //loading cols
        Configurations.setColumnView(colDay, "day");
        Configurations.setColumnView(colExercice, "excercise");
        Configurations.setColumnView(colRepetitions, "repetitions");
        Configurations.setColumnView(colSeries, "series");

    }

    private void getSubrutine() {
        btnDeleteSubRutine.setDisable(false);
        btnEditExcercise.setDisable(false);
        subRutine = (SubRutine) tableRutine.getSelectionModel().getSelectedItem();

        txtFExercice.setText(subRutine.getExcercise());
        txtFReps.setText(subRutine.getRepetitions());
        Configurations.configSpinner_Int(1, 10, subRutine.getSeries(), spnSeries);
        Configurations.configSpinner_Int(1, 6, subRutine.getDay(), spnDay);

    }

    //------------------------------CRUD Methods----------------------------//
    public void addSubrutine() {
        subRutine = new SubRutine();

        //setting subRutine values
        subRutine.setDay((int) spnDay.getValue());
        subRutine.setExcercise(txtFExercice.getText());
        subRutine.setRepetitions(txtFReps.getText());
        subRutine.setRutine(rutine);
        subRutine.setSeries((int) spnSeries.getValue());

        list.add(subRutine);

        loadTable(list);
    }

    private void saveRutine() {
        if (!list.isEmpty() && true) {

        }
        rutineService.create(rutine);
    }

    private void deleteSubRutine() {
        getSubrutine();
        list.remove(subRutine);

        loadTable(list);

    }

    private void updateSubRutine() {
       
        //list.r
    }
    
    private int getSubRutinePosition(){
        getSubrutine();
        int position = -1;
        
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).equals(subRutine)){
                position = i;
                break;
            }
        }
        
        return position;
    }

}
