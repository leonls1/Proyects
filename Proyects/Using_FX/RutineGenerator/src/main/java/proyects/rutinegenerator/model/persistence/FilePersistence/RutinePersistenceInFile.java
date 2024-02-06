package proyects.rutinegenerator.model.persistence.FilePersistence;

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
    //private final String RutinePath = "C:\\Users\\leonl\\Documents\\NetBeansProyects\\Proyects\\Using_FX\\RutineGenerator\\src\\main\\resources\\data\\rutines.dat";
private final String RutinePath = "rutines.dat";
    /*    private final String RutinePath = "RutineGenerator" + File.separator
            + "src" + File.separator
            + "main" + File.separator
            + "resources" + File.separator
            + "data" + File.separator
            + "rutines.dat";
     */
    private void getOOS() throws FileNotFoundException, IOException {
        if (oos == null) {
            oos = new ObjectOutputStream(new FileOutputStream(RutinePath));
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
        System.out.println(new File(RutinePath).getPath());
        System.out.println(new File(RutinePath).getAbsolutePath());
        List<Rutine> rutines = new ArrayList<>();

        try {
            getOIS();
            while (true) {
                Rutine r = (Rutine) ois.readObject();
                rutines.add(r);
            }

        } catch (IOException | ClassNotFoundException ex) {

        }
        if (rutines.isEmpty()) {
            System.out.println("There's no rutines recorded");
            return null;
        }
        return rutines;

    }
}
