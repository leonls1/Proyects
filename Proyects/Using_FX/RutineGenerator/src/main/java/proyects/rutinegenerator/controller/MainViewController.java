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
import proyects.rutinegenerator.utilities.BasicLoaders;

public class MainViewController implements Initializable {

    private List<Excercise> ejerciciosEspalda, ejerciciosPecho, ejerciciosHombro;

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
            generateRutine(cboRutineType.getSelectionModel().getSelectedItem());
            System.out.println(rutine);
            filePersistence.saveRutine(rutine);
        }

    }

    @FXML
    public void mouseEvent(MouseEvent evt) {

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        BasicLoaders.generateExercices(ejerciciosEspalda, ejerciciosPecho, ejerciciosHombro);
        BasicLoaders.loadCBO(cboRutineType, cboLevel);
        filePersistence.getAllRutines();
        

    }

    public void loadTable() {
        repCol.setCellValueFactory(new PropertyValueFactory<>("repetitions"));
        serieCol.setCellValueFactory(new PropertyValueFactory<>("series"));
        excerciceCol.setCellValueFactory(cellData -> {
            Excercise exercise = cellData.getValue().getExcercise();
            String name = (exercise != null) ? exercise.getName() : "";
            return new SimpleStringProperty(name);
        });
        tableRutine.setItems(FXCollections.observableArrayList(rutine.getSubRutines()));
    }    

    private SubRutine generateSubRutine(String type, String muscle) {
        int reps, series;
        reps = series = 0;
        Random rand = new Random();

        switch (type) {
            case "fuerza":
                reps = 1 + rand.nextInt(5);
                series = 1 + rand.nextInt(6);
                break;

            case "resistencia":
                reps = 12 + rand.nextInt(9);
                series = 1 + rand.nextInt(4);
                break;
            case "hipertrofia":
                reps = 6 + rand.nextInt(7);
                series = 1 + rand.nextInt(6);
                break;
        }

        return new SubRutine(generateRandomExercice(muscle), series, reps);
    }

    private Excercise generateRandomExercice(String muscle) {
        Random rand = new Random();
        Excercise randomExcercise;
        int randomElement;

        if (muscle.equalsIgnoreCase("espalda")) {
            randomElement = rand.nextInt(ejerciciosEspalda.size());
            randomExcercise = ejerciciosEspalda.get(randomElement);

        } else if (muscle.equalsIgnoreCase("pecho")) {
            randomElement = rand.nextInt(ejerciciosPecho.size());
            randomExcercise = ejerciciosPecho.get(randomElement);

        } else {
            randomElement = rand.nextInt(ejerciciosHombro.size());
            randomExcercise = ejerciciosHombro.get(randomElement);
        }
        return randomExcercise;

    }

    private void generateRutine(String type) {
        List<SubRutine> subRutines = new ArrayList<>();
        subRutines.add(generateSubRutine(type, "espalda"));
        subRutines.add(generateSubRutine(type, "espalda"));
        subRutines.add(generateSubRutine(type, "espalda"));

        subRutines.add(generateSubRutine(type, "pecho"));
        subRutines.add(generateSubRutine(type, "pecho"));
        subRutines.add(generateSubRutine(type, "pecho"));

        subRutines.add(generateSubRutine(type, "hombro"));
        subRutines.add(generateSubRutine(type, "hombro"));
        subRutines.add(generateSubRutine(type, "hombro"));

        this.rutine = new Rutine("ruina de: " + type, subRutines);

        loadTable();

    }
}
