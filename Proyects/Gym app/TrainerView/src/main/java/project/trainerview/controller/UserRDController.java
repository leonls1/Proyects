/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package project.trainerview.controller;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import project.trainerview.App;
import project.trainerview.model.entities.User;
import project.trainerview.model.persistence.UserDAO;
import project.trainerview.service.UserService;
import project.trainerview.utilities.factories.DAOFactory;
import project.trainerview.utilities.other.Configurations;
import project.trainerview.utilities.other.ConfirmationsValidations;

/**
 * FXML Controller class
 *
 * @author leon
 */
public class UserRDController implements Initializable {

    private UserDAO serviceUser;
    
    private UserService service;

    private List<User> list;

    private User user;

    @FXML
    private Button btnSearch, btnMenu, btnDelete, btnEdit, btnUpdate;

    @FXML
    private TextField txtFSearch, txtFId, txtFName, txtFSurname;

    @FXML
    private TableView<User> tableUsers;

    @FXML
    private TableColumn colName, colSurname, colId, colExpirationDate;

    @FXML
    private void btnEvent(ActionEvent event) {
        Object evt = event.getSource();

        if (evt.equals(btnDelete)) {

            deleteUser();

        } else if (evt.equals(btnEdit)) {
            enableEdit();

        } else if (evt.equals(btnMenu)) {
            try {
                App.setRoot("Menu", 340, 270);
            } catch (IOException ex) {
            }

        } else if (evt.equals(btnSearch)) {
            searhUser();

        } else if (evt.equals(btnUpdate)) {
            updateUser();
        }
    }

    @FXML
    private void mouseEvent(MouseEvent event) {
        Object evt = event.getSource();

        if (evt.equals(tableUsers)) {
            loadUser();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        serviceUser = DAOFactory.geUserDAO();
        service = new UserService();
        list = serviceUser.getAll();
        loadTable(list);

    }


    //-----------------------------------Interface methods----------------------------------------//
    private void loadTable(List<User> list) {
        //getting all users from db

        Configurations.loadTable(tableUsers, FXCollections.observableArrayList(list));

        //loading cols
        Configurations.setColumnView(colId, "id");
        Configurations.setColumnView(colName, "name");
        Configurations.setColumnView(colSurname, "surname");
        Configurations.setColumnView(colExpirationDate, "expirationDate");
    }

    private void loadUser() {
        user = tableUsers.getSelectionModel().getSelectedItem();

        btnEdit.setDisable(false);
        btnDelete.setDisable(false);
        btnUpdate.setDisable(true);

        txtFId.setText(user.getId().toString());
        txtFName.setText(user.getName());
        txtFSurname.setText(user.getSurname());
    }

    private void enableEdit() {
        txtFName.setDisable(false);
        txtFSurname.setDisable(false);
        btnUpdate.setDisable(false);
    }

    private void disableEdit() {
        btnDelete.setDisable(true);
        btnEdit.setDisable(true);
        btnUpdate.setDisable(true);

        txtFName.setDisable(true);
        txtFSurname.setDisable(true);
    }
//-----------------------------------CRUD methods----------------------------------------//
    private void updateUser() {
        user.setSurname(txtFSurname.getText());
        user.setName(txtFName.getText());
        if (ConfirmationsValidations.confirnationMessage("CONFIRMACION", "Actualizar usuario", user.getName() + " " + user.getSurname())) {
            serviceUser.update(user);
            loadTable(list);
            disableEdit();
        }
    }

    private void deleteUser() {
        if (ConfirmationsValidations.confirnationMessage("CONFIRMACION", "Borrar usuario", user.getName() + " " + user.getSurname())) {
            serviceUser.delete(user);
            loadTable(list);
            disableEdit();
        }
    }
    //it could be performed with an observable
    private void searhUser(){
        if(!txtFSearch.getText().isBlank()){
            list = service.filterUser(txtFSearch.getText().strip().toLowerCase());
        }else{
            list = serviceUser.getAll();
        }
        loadTable(list);
        disableEdit();
        
    }

}
