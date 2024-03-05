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
import project.trainerview.service.RutineService;
import project.trainerview.service.UserService;
import project.trainerview.utilities.converters.UserConverter;
import project.trainerview.utilities.factories.DAOFactory;
import project.trainerview.utilities.other.Configurations;
import project.trainerview.utilities.other.ConfirmationsValidations;

/**
 * FXML Controller class
 *
 * @author leon
 */
public class RutineCreateController implements Initializable {

    private Rutine rutine;

    private RutineService rutineService;

    private List<SubRutine> list;

    private List<User> listUsers;

    private SubRutine subRutine;

    private User user;

    private UserDAO userService;

    private UserService service;

    @FXML
    private TextField txtFExercice, txtFReps, txtFFilter;

    @FXML
    private Spinner spnSeries, spnDay;

    @FXML
    private ComboBox cboUser;

    @FXML
    private Button btnAddExercice, btnMenu, btnDeleteSubRutine, btnSaveRutine, btnEditExcercise, btnFilter;

    @FXML
    private TableView tableRutine;

    @FXML
    private TableColumn colExercice, colRepetitions, colSeries, colDay;

    @FXML
    private void btnEvent(ActionEvent event) {
        Object evt = event.getSource();

        if (evt.equals(btnMenu)) {
            if (user != null || !list.isEmpty()) {
                if (ConfirmationsValidations.confirnationMessage("Descargar cambios", "Salir sin guardar",
                        "Desea volver al menu? los cambios no guardados se perderan")) {
                    try {
                        App.setRoot("Menu", 340, 270);
                    } catch (IOException e) {
                    }
                }
            } else {
                try {
                    App.setRoot("Menu", 340, 270);
                } catch (IOException e) {
                }
            }

        } else if (evt.equals(btnDeleteSubRutine)) {
            deleteSubRutine();

        } else if (evt.equals(btnSaveRutine)) {
            saveRutine();

        } else if (evt.equals(btnAddExercice)) {
            addSubrutine();
        } else if (evt.equals(btnEditExcercise)) {

        } else if (evt.equals(btnFilter)) {
            cboUser.setItems(FXCollections.observableArrayList(
                    service.filterUser(txtFFilter.getText())
            ));
            this.user = null;

        }
    }

    @FXML
    private void cboEvent(ActionEvent event) {
        Object evt = event.getSource();
        if (evt.equals(cboUser)) {
            user = (User) cboUser.getSelectionModel().getSelectedItem();
            btnDeleteSubRutine.setDisable(true);
        }
    }

    @FXML
    private void mouseEvent(MouseEvent event) {
        if (event.getSource().equals(tableRutine)) {
            btnDeleteSubRutine.setDisable(false);
            getSubrutine();

        }

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //setting spinner configuration
        Configurations.configSpinner_Int(1, 6, 3, spnDay);
        Configurations.configSpinner_Int(1, 10, 3, spnSeries);
        rutine = new Rutine();
        list = new ArrayList<>();
        rutineService = new RutineService();
        userService = DAOFactory.geUserDAO();
        service = new UserService();
        configCBO();


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

    private void configCBO() {
        //----------------------cboConfig-------------------//
        listUsers = new ArrayList<>();
        listUsers = userService.getAll();
        cboUser.setItems(FXCollections.observableArrayList(listUsers));
        /*
        //adding the listener to the cbo 
        cboUser.getEditor().textProperty().addListener((observable, oldValue, newValue) -> {
            //setting the filter to look for the user introduced
            cboUser.setItems(
                    FXCollections.observableArrayList(listUsers.stream().
                            filter(us -> us.toString().toLowerCase().contains(newValue.toLowerCase()))));
        });
         */
        //setting the converter
        UserConverter userConverter = new UserConverter(cboUser);
        cboUser.setConverter(userConverter);
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

        btnDeleteSubRutine.setDisable(true);

        list.add(subRutine);

        loadTable(list);
    }

    private void saveRutine() {
        if (list.isEmpty()) {
            Configurations.showErrorAlert("Rutina vacia", "No se han agregadon ningun ejercicio a la rutina");

        } else if (user == null) {
            Configurations.showErrorAlert("Usuario Invalido", "No se ha seleccionado ningun usuario");

        } else {
            if (ConfirmationsValidations.confirnationMessage("Guadar rutina", "Desear guardar la nueva rutina", "La nueva rutina para:  \""
                    + user.getName() + " " + user.getSurname() + "\" \n sustuira la anterior, desea continuar?")) {

                //saving the rutine

                if (user.getRutine() == null) {
                    loadRutine();

                    rutineService.saveRutine(rutine);
                }else{
                    rutineService.updateRutine(rutine, list);
                }
                btnDeleteSubRutine.setDisable(true);
                list.removeAll(list);
                loadTable(list);
            }

        }

    }

    private void loadRutine() {
        this.rutine = new Rutine();
        this.rutine.setSubRutines(list);
        this.rutine.setUser(user);
    }

    private void deleteSubRutine() {
        getSubrutine();
        list.remove(subRutine);
        btnDeleteSubRutine.setDisable(true);

        loadTable(list);

    }
    /*
    private void updateSubRutine() {

        //list.r
    }

    private int getSubRutinePosition() {
        getSubrutine();
        int position = -1;

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals(subRutine)) {
                position = i;
                break;
            }
        }

        return position;
    }
     */
}
