package proyects.rutinegenerator.utilities;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import proyects.rutinegenerator.model.entity.Excercise;
import proyects.rutinegenerator.model.entity.Rutine;
import proyects.rutinegenerator.model.entity.SubRutine;

public class BasicGenerators {

    //generar una rutina de forma aleatoria con valores ya establecidos, rutina basica para pecho, espalda y hombro
    public static void generateRutine(String type, String level, List<Excercise> exercices, Rutine rutine) {
        List<List<String>> listOfList;
        List<SubRutine> subRutines = new ArrayList<>();
        /*
        subRutines.add(generateSubRutine(type, "espalda", level, exercices));
        subRutines.add(generateSubRutine(type, "espalda", level, exercices));
        subRutines.add(generateSubRutine(type, "espalda", level, exercices));

        subRutines.add(generateSubRutine(type, "pecho", level, exercices));
        subRutines.add(generateSubRutine(type, "pecho", level, exercices));
        subRutines.add(generateSubRutine(type, "pecho", level, exercices));

        subRutines.add(generateSubRutine(type, "hombro", level, exercices));
        subRutines.add(generateSubRutine(type, "hombro", level, exercices));
        subRutines.add(generateSubRutine(type, "hombro", level, exercices));
         */
//        rutine = new Rutine("ruina de: " + type, subRutines);

    }
//genera un subrutina en base a un tipo de ejercicio, tipo de musculo, nivel del usuario y lo toma de una
    //lista de ejercicios pasados por parametro
//etnonces la subrutina tendria que generar varias subrutinas de un solo grupo muscular, asi de paso tiene en cuenta
    //cuantas series en la semana esta haciendo

    public static SubRutine generateSubRutine(String type, String level, List<Excercise> exercices, int day) {
        int reps, series;
        reps = series = 0;
        Random rand = new Random();
        switch (type) {
            case "fuerza":
                reps += 1 + rand.nextInt(6);
                switch (level) {
                    case "Principiante":
                        series += 2 + rand.nextInt(2);
                        break;

                    case "Intermedio":
                        series += 3 + rand.nextInt(2);
                        break;

                    case "Avanzado":
                        series += 4 + rand.nextInt(3);
                        break;
                }
                break;

            case "resistencia":
                reps += 15 + rand.nextInt(76) / 5;
                switch (level) {
                    case "Principiante":
                        series += 2 + rand.nextInt(2);
                        break;

                    case "Intermedio":
                        series += 3 + rand.nextInt(2);
                        break;

                    case "Avanzado":
                        series += 4 + rand.nextInt(3);
                        break;
                }   
                break;

            case "hipertrofia":
                reps += 7 + (rand.nextInt(19)) / 2;
                switch (level) {
                    case "Principiante":
                        series += 3 + rand.nextInt(2);
                        break;

                    case "Intermedio":
                        series += 4 + rand.nextInt(2);
                        break;

                    case "Avanzado":
                        series += 5 + rand.nextInt(3);
                        break;
                }
                break;

        }

        return new SubRutine((Excercise) pickRamdomFromlist(exercices), series, reps, day);
    }
//en base a una lista de ejercicios pasados por parametro de devuelve un valor aleatorio del mismo

    private static <T> Object pickRamdomFromlist(List<T> list) {
        Random rand = new Random();
        if (!(list == null)) {
            return list.get(rand.nextInt(list.size()));
        } else {
            return null;
        }

    }
}
