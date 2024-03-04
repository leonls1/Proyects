package project.trainerview.service;

import project.trainerview.model.entities.Rutine;
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
        System.out.println("new user rutine: " + rutine.getUser().getRutine());
        
        userDAO.update(rutine.getUser());

        //setting all subRutines and saving them
        rutineDAO.create(rutine);
        rutine.getSubRutines().stream().
                forEach(sub -> {
                    sub.setRutine(rutine);
                    subRutineDAO.create(sub);
                });

    }

    public void deleteRutine(Rutine rutine) {
        //rutine.getSubRutines().stream().
        //        forEach(sub -> subRutineDAO.delete(sub));
        rutineDAO.delete(rutine);
    }
}
