package project.trainerview.service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;
import java.util.List;
import project.trainerview.model.entities.Rutine;
import project.trainerview.model.entities.SubRutine;
import project.trainerview.model.persistence.RutineDAO;
import project.trainerview.model.persistence.SubRutineDAO;
import project.trainerview.model.persistence.UserDAO;
import project.trainerview.utilities.factories.DAOFactory;

public class RutineService {

    private final RutineDAO rutineDAO = DAOFactory.geRutineDAO();
    private final UserDAO userDAO = DAOFactory.geUserDAO();
    private final SubRutineDAO subRutineDAO = DAOFactory.geSubRutineDAO();

    public RutineDAO getRutineDAO() {
        return rutineDAO;
    }

    public void saveRutine(Rutine rutine) {

        //setting the user to the current rutine
        rutine.getUser().setRutine(rutine);
        userDAO.update(rutine.getUser());

        //setting all subRutines and saving them
        rutineDAO.create(rutine);

        rutine.getSubRutines().
                forEach(sub -> {
                    sub.setRutine(rutine);
                    subRutineDAO.create(sub);
                });

    }

    public void updateRutine(Rutine rutine, List<SubRutine> list) {        
        rutine.getSubRutines().forEach(sub -> subRutineDAO.delete(sub));       
        
        rutine.setSubRutines(list);
        rutineDAO.update(rutine);
        
        rutine.getSubRutines().stream().forEach(subRutine -> {
                    subRutine.setRutine(rutine);
                    subRutineDAO.create(subRutine);
                });

        //setting all subRutines and saving them
        //rutine.setSubRutines(list);

       

    }

    public void deleteRutine(Rutine rutine) {
        rutine.getSubRutines().stream().
                forEach(sub -> subRutineDAO.delete(sub));
        rutineDAO.delete(rutine);
    }
}
