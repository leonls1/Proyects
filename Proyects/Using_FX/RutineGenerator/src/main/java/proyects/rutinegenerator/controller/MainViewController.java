/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package proyects.rutinegenerator.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import proyects.rutinegenerator.model.Excercise;
import proyects.rutinegenerator.model.Rutine;
import proyects.rutinegenerator.model.SubRutine;

public class MainViewController implements Initializable {

    private List<Excercise> ejerciciosEspalda, ejerciciosPecho, ejerciciosHombro;

    private Rutine rutine;

    @FXML
    private Button btnGenerate;

    @FXML
    private TableView<Rutine> tableRutine;

    @FXML
    private ComboBox<String> cboRutineType;
    
    @FXML
    private TableColumn excerciceCol, serieCol, repCol; 

    @FXML
    public void cboEvent(ActionEvent evt) {

    }

    @FXML
    public void btnEvent(ActionEvent evt) {
        generateRutine(cboRutineType.getSelectionModel().getSelectedItem());
        System.out.println(rutine);
    }

    @FXML
    public void mouseEvent(MouseEvent evt) {

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        generateExercices();
        ArrayList<String> types = new ArrayList<>();
        types.add("fuerza");
        types.add("resistencia");
        types.add("hipertrofia");
        cboRutineType.setItems(FXCollections.observableArrayList(types));
    }

    private void generateExercices() {

        ejerciciosEspalda = ejerciciosPecho = ejerciciosHombro = new ArrayList<>();

        //generando algunos ejercicos para probar
        Excercise exePecho1 = new Excercise("Press Banca plano", "pecho");
        Excercise exePecho2 = new Excercise("Press Banca inclinado", "pecho");
        Excercise exePecho3 = new Excercise("Press Banca declinado", "pecho");
        Excercise exePecho4 = new Excercise("Apertuar con mancuernas incliando", "pecho");

        Excercise exeHombro1 = new Excercise("Press militar", "hombro");
        Excercise exeHombro2 = new Excercise("Vuelo frontal", "hombro");
        Excercise exeHombro3 = new Excercise("Vuelo lateral", "hombro");
        Excercise exeHombro4 = new Excercise("Vuelo posterior", "hombro");
        Excercise exeHombro5 = new Excercise("Jalon a la cara", "hombro");

        Excercise exeEspalda1 = new Excercise("Remo en barra acostado", "espalda");
        Excercise exeEspalda2 = new Excercise("Jalon al pecho", "espalda");
        Excercise exeEspalda3 = new Excercise("Dominada prona lastrada", "espalda");
        Excercise exeEspalda4 = new Excercise("Dominada supina lastrada", "espalda");

        ejerciciosEspalda.add(exeEspalda1);
        ejerciciosEspalda.add(exeEspalda2);
        ejerciciosEspalda.add(exeEspalda3);
        ejerciciosEspalda.add(exeEspalda4);

        ejerciciosPecho.add(exePecho4);
        ejerciciosPecho.add(exePecho3);
        ejerciciosPecho.add(exePecho2);
        ejerciciosPecho.add(exePecho1);

        ejerciciosHombro.add(exeHombro1);
        ejerciciosHombro.add(exeHombro2);
        ejerciciosHombro.add(exeHombro3);
        ejerciciosHombro.add(exeHombro4);
        ejerciciosHombro.add(exeHombro5);

    }

    private SubRutine generateSubRutine(String type, String muscle) {
        int reps, series;
        reps = series = 0;
        Random rand = new Random();

        switch (type) {
            case "fuerza":
                reps = rand.nextInt( 6);
                series = rand.nextInt( 7);
                break;

            case "resistencia":
                reps = rand.nextInt( 20);
                series = rand.nextInt( 5);
                break;
            case "hipertrofia":
                reps = rand.nextInt( 13);
                series = rand.nextInt( 7);
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

    }
}
