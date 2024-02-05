package Task.controller;

import Task.model.Task;
import Task.model.TaskType;
import Task.service.TaskDao;
import Task.service.TaskImp;
import Task.service.TaskTypeDao;
import Task.service.TaskTypeImp;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import java.util.List;
import java.util.Optional;
import javafx.collections.FXCollections;
import javafx.scene.control.CheckBox;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import java.util.stream.Collectors;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.stage.Modality;

public class MainController implements Initializable {

    @FXML
    private CheckBox chkonlyImportant;

    @FXML
    private Button btnDelete, btnSave, btnUpdate, btnDetail, btnClear, btnEdit;

    @FXML
    private TextField txtName;

    @FXML
    private DatePicker dtpStart, dtpEnd;

    @FXML
    private RadioButton radioYes, radioNo;

    @FXML
    private ComboBox<TaskType> cboType;

    @FXML
    private TextArea txtDescription;

    @FXML
    private TableView<Task> tasksTable;

    @FXML
    private TableColumn idCol, nameCol, startCol, endCol, typeCol, importantCol;

    private TaskDao taskService;

    private TaskTypeDao taskTypeService;

    private Task task;

    private List<Task> list;

    @FXML
    private void btnEvent(ActionEvent event) {
        Object evt = event.getSource();

        if (evt.equals(btnClear)) {
            clearFields();

        } else if (evt.equals(btnDelete)) {
            deleteTask();

        } else if (evt.equals(btnDetail)) {
            //to do later

        } else if (evt.equals(btnSave)) {
            saveTask();

        } else if (evt.equals(btnUpdate)) {
            updateTask();

        } else if (evt.equals(btnEdit)) {
            btnUpdate.setDisable(false);
            enableEdit();

        } else if (evt.equals(chkonlyImportant)) {
            if (chkonlyImportant.isSelected()) {
                getImportantOnly();
            } else {
                getAllTask();
            }
        }

    }

    @FXML
    private void mouseEvent(MouseEvent evt) {
        Object obj = evt.getSource();
        if (obj.equals(tasksTable)) {
            btnSave.setDisable(true);
            btnEdit.setDisable(false);
            btnDelete.setDisable(false);
            cboType.setDisable(true);

            txtName.setDisable(true);
            dtpEnd.setDisable(true);
            dtpStart.setDisable(true);
            txtDescription.setDisable(true);
            radioNo.setDisable(true);
            radioYes.setDisable(true);

            task = tasksTable.getSelectionModel().getSelectedItem();
            setCurrentTask();
        }
    }

    @FXML
    private void cboEvent(ActionEvent event) {
        Object evt = event.getSource();

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        dtpEnd.setValue(LocalDate.now());
        dtpStart.setValue(LocalDate.now());

        taskService = new TaskImp();
        taskTypeService = new TaskTypeImp();
        task = new Task();
        getAllTask();
        getTypes();
    }

    private void setCurrentTask() {
        txtName.setText(task.getName());
        txtDescription.setText(task.getDescription());
        dtpEnd.setValue(task.getEndDate());
        dtpStart.setValue(task.getCreationDate());
        cboType.setValue(task.getTaskType());

    }

    private void deleteTask() {

        if (confirmation("Delete confirmation")) {
            taskService.delete(task);
            clearFields();
            getAllTask();

        } else {
            System.out.println("canceled");
        }
    }

    private void enableEdit() {

        txtName.setDisable(false);
        dtpEnd.setDisable(false);
        dtpStart.setDisable(false);
        txtDescription.setDisable(false);
        radioNo.setDisable(false);
        radioYes.setDisable(false);
        cboType.setDisable(false);

    }

    private void getAllTask() {

        list = taskService.getAll();
        loadTable();

    }

    private void getImportantOnly() {
        this.list = list.stream().filter(
                t -> t.isImportant()).collect(Collectors.toList());
        loadTable();
    }

    private void getTypes() {
        List<TaskType> listTypes = taskTypeService.getAll();
        cboType.setItems(FXCollections.observableArrayList(listTypes));

    }

    private void clearFields() {
        txtDescription.setText("");
        txtName.setText("");
        dtpEnd.setValue(LocalDate.now());
        dtpStart.setValue(LocalDate.now());

        task = new Task();

        btnEdit.setDisable(false);
        btnUpdate.setDisable(true);
        btnDelete.setDisable(true);
        btnDetail.setDisable(true);
        btnSave.setDisable(false);

        enableEdit();
    }

    private void saveTask() {
        loadTask();
        System.out.println(cboType.getSelectionModel().getSelectedIndex());

        if (confirmation("Add confirmation")) {
            taskService.create(task);
            getAllTask();
            clearFields();

        } else {
            System.out.println("canceled");
        }

    }

    private void loadTask() {
        task.setEndDate(dtpEnd.getValue());
        task.setCreationDate(dtpStart.getValue());
        task.setName(txtName.getText());
        task.setTaskType(cboType.getSelectionModel().getSelectedItem());
        task.setDescription(txtDescription.getText());

        if (radioYes.isSelected()) {
            task.setImportant(true);
        } else {
            task.setImportant(false);
        }

    }

    private void loadTable() {
        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        startCol.setCellValueFactory(new PropertyValueFactory<>("creationDate"));
        endCol.setCellValueFactory(new PropertyValueFactory<>("endDate"));
        typeCol.setCellValueFactory(new PropertyValueFactory<>("taskType"));
        importantCol.setCellValueFactory(new PropertyValueFactory<>("important"));

        tasksTable.setItems(FXCollections.observableArrayList(list));
        tasksTable.refresh();
    }

    private void updateTask() {
        if (confirmation("Update confirmation")) {
            loadTask();
            taskService.update(this.task);
            getAllTask();
        } else {
            System.out.println("Update canceled");
        }
    }

    private boolean confirmation(String message) {
        //definicion de la ventana emergente
        Dialog<ButtonType> dialog = new Dialog<>();
        dialog.setTitle(message);
        dialog.setHeaderText("Do you want to save the task?");
        dialog.initModality(Modality.WINDOW_MODAL);

        //definicion de la etiqueta que tengra la ventana
        Label label = new Label("Name :" + txtName.getText());
        dialog.getDialogPane().setContent(label);

        //definicion de los botones ok y cancel
        ButtonType okButton = new ButtonType("OK", ButtonBar.ButtonData.OK_DONE);
        ButtonType cancelButton = new ButtonType("CANCEL", ButtonBar.ButtonData.CANCEL_CLOSE);

        //agregado de los botones al dialog
        dialog.getDialogPane().getButtonTypes().addAll(okButton, cancelButton);

        Optional<ButtonType> result = dialog.showAndWait();

        return (result.isPresent() && result.get() == okButton);
    }
}
