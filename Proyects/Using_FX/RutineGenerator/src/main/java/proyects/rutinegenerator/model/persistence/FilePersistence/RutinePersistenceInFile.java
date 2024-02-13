package proyects.rutinegenerator.model.persistence.FilePersistence;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import proyects.rutinegenerator.model.entity.Rutine;

public class RutinePersistenceInFile {

    private ObjectInputStream ois;
    private ObjectOutputStream oos;

    private final String RutinePath = "src" + File.separator
            + "main" + File.separator
            + "resources" + File.separator
            + "data" + File.separator
            + "rutines.dat";

    private void getOOS() throws FileNotFoundException, IOException {
        if (oos == null) {
            oos = new ObjectOutputStream(new FileOutputStream(RutinePath, true));
        }
    }

    private void getOIS() throws FileNotFoundException, IOException {
        if (ois == null) {
            ois = new ObjectInputStream(new FileInputStream(RutinePath));

        }
    }

    public void saveRutine(Rutine rut) {
        try {
            getOOS();
            oos.writeObject(rut);
            System.out.println("rutine saved");
        } catch (IOException ex) {
            System.out.println("No se ha podido guardar la rutina");
        }
    }

    public List<Rutine> getAllRutines() {
        List<Rutine> rutines = new ArrayList<>();

        try {
            getOIS();
            while (true) {
                try {
                    Rutine r = (Rutine) ois.readObject();
                    rutines.add(r);
                } catch (EOFException ex) {
                    break;
                }
            }
            
        } catch (IOException | ClassNotFoundException ex) {
            System.out.println("Error while getting rutines: " + ex.getMessage());
            ex.printStackTrace();
        } finally {
            try {
                if (ois != null) {
                    ois.close();
                }

            } catch (Exception e) {
            }
        }
        if (rutines.isEmpty()) {

            return null;
        }
        return rutines;

    }
}
