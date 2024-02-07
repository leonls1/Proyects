package proyects.rutinegenerator.utilities;

import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.scene.control.ComboBox;
import proyects.rutinegenerator.model.entity.Excercise;


public class BasicLoaders {

    public static void loadCBO(ComboBox cboRutineType, ComboBox  cboLevel) {
        ArrayList<String> types = new ArrayList<>();
        types.add("fuerza"); //2-3 veces por semana 2-3 series por grupo muscular y entre 1 y 6 repeticiones
        types.add("hipertrofia");//2-3 veces por semana 3-4 series por grupo muscular y entre 6 y 12 repeticiones
        types.add("resistencia");//3-4 veces por semana 2-3 series por grupo muscular y mas de 12 repeticiones      
        
        ArrayList<String> levels = new ArrayList<>();
        levels.add("Principiante");
        levels.add("Intermedio");
        levels.add("Avanzado");
        
        cboRutineType.setItems(FXCollections.observableArrayList(types));
        cboLevel.setItems(FXCollections.observableArrayList(levels));     

    }
    
     public static void generateExercices(List<Excercise> backExcercises, List<Excercise> chestExcercises, List<Excercise> shoulderExcercises) {

        backExcercises = chestExcercises = shoulderExcercises = new ArrayList<>();

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

        backExcercises.add(exeEspalda1);
        backExcercises.add(exeEspalda2);
        backExcercises.add(exeEspalda3);
        backExcercises.add(exeEspalda4);

        chestExcercises.add(exePecho4);
        chestExcercises.add(exePecho3);
        chestExcercises.add(exePecho2);
        chestExcercises.add(exePecho1);

        shoulderExcercises.add(exeHombro1);
        shoulderExcercises.add(exeHombro2);
        shoulderExcercises.add(exeHombro3);
        shoulderExcercises.add(exeHombro4);
        shoulderExcercises.add(exeHombro5);

    }
}
