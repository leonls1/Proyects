package proyects.rutinegenerator.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import proyects.rutinegenerator.model.entity.Excercise;
import proyects.rutinegenerator.model.entity.Rutine;
import proyects.rutinegenerator.model.entity.SubRutine;
import proyects.rutinegenerator.model.persistence.FilePersistence.RutinePersistenceInFile;
import proyects.rutinegenerator.utilities.BasicGenerators;
import proyects.rutinegenerator.utilities.BasicLoaders;

public class MainViewController implements Initializable {

    private List<Excercise> ejerciciosEspalda = new ArrayList<>();
    private List<Excercise> ejerciciosPecho = new ArrayList<>();
    private List<Excercise> ejerciciosHombro = new ArrayList<>();
    ;

    private Rutine rutine;

    private final RutinePersistenceInFile filePersistence = new RutinePersistenceInFile();

    @FXML
    private Button btnGenerate;

    @FXML
    private TableView<SubRutine> tableRutine;

    @FXML
    private ComboBox<String> cboRutineType, cboLevel;

    @FXML
    private TableColumn<SubRutine, String> excerciceCol, serieCol, repCol, dayCol, muscleCol;

    @FXML
    public void cboEvent(ActionEvent evt) {

    }

    @FXML
    public void btnEvent(ActionEvent evt) {
        Object e = evt.getSource();
        if (e.equals(btnGenerate)) {
            generateRutine(cboRutineType.getSelectionModel().getSelectedItem(), cboLevel.getSelectionModel().getSelectedItem());
            /*BasicGenerators.generateRutine(cboRutineType.getSelectionModel().getSelectedItem(),
                    cboLevel.getSelectionModel().getSelectedItem(), 
                    ,
                    rutine);*/
            filePersistence.saveRutine(rutine);
        }

    }

    @FXML
    public void mouseEvent(MouseEvent evt) {

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        BasicLoaders.loadCBO(cboRutineType, cboLevel);
        BasicLoaders.generateExercices(ejerciciosEspalda, ejerciciosPecho, ejerciciosHombro);
        filePersistence.getAllRutines();

    }

    public void loadTable() {
        repCol.setCellValueFactory(new PropertyValueFactory<>("repetitions"));
        serieCol.setCellValueFactory(new PropertyValueFactory<>("series"));
        dayCol.setCellValueFactory(new PropertyValueFactory<>("day"));

        //cargando la columna del nombre del ejercicio en cada subRutina
        excerciceCol.setCellValueFactory(cellData -> {
            Excercise exercise = cellData.getValue().getExcercise();
            String name = (exercise != null) ? exercise.getName() : "";
            return new SimpleStringProperty(name);
        });

        //cargando la columna de los musculos para cada ejercicio
        muscleCol.setCellValueFactory(cellData -> {
            Excercise exe = cellData.getValue().getExcercise();
            String muscle = (exe != null) ? exe.getMuscle() : "";
            return new SimpleStringProperty(muscle);
        });

        tableRutine.setItems(FXCollections.observableArrayList(rutine.getSubRutines()));
    }

    private void generateRutine(String type, String level) {

        List<SubRutine> subRutines = new ArrayList<>();

        subRutines.add(BasicGenerators.generateSubRutine(type, level, ejerciciosEspalda, 1));
        subRutines.add(BasicGenerators.generateSubRutine(type, level, ejerciciosEspalda, 1));
        subRutines.add(BasicGenerators.generateSubRutine(type, level, ejerciciosEspalda, 1));

        subRutines.add(BasicGenerators.generateSubRutine(type, level, ejerciciosPecho, 2));
        subRutines.add(BasicGenerators.generateSubRutine(type, level, ejerciciosPecho, 2));
        subRutines.add(BasicGenerators.generateSubRutine(type, level, ejerciciosPecho, 2));

        subRutines.add(BasicGenerators.generateSubRutine(type, level, ejerciciosHombro, 3));
        subRutines.add(BasicGenerators.generateSubRutine(type, level, ejerciciosHombro, 3));
        subRutines.add(BasicGenerators.generateSubRutine(type, level, ejerciciosHombro, 3));

        this.rutine = new Rutine("ruina de: " + type, subRutines);

        loadTable();

    }
}
