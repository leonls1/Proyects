package project.userview.service;

import java.util.List;
import project.userview.model.entities.Rutine;
import project.userview.model.entities.SubRutine;
import project.userview.model.persistence.RutineDAO;
import project.userview.model.persistence.SubRutineDAO;
import project.userview.model.persistence.UserDAO;
import project.userview.utilities.factories.DAOFactory;

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

        rutine.getSubRutines().stream().
                forEach(sub -> {
                    sub.setRutine(rutine);
                    subRutineDAO.create(sub);
                });

    }

    public void updateRutine(Rutine rutine, List<SubRutine> list) {
        rutine.getSubRutines().stream().  
                forEach(sub -> subRutineDAO.delete(sub));
        
        rutine.setSubRutines(list);
        
         //setting all subRutines and saving them
        rutineDAO.update(rutine);

        rutine.getSubRutines().stream().
                forEach(sub -> {
                    sub.setRutine(rutine);
                    subRutineDAO.create(sub);
                });
        
        
    }

    public void deleteRutine(Rutine rutine) {
        rutine.getSubRutines().stream().
                forEach(sub -> subRutineDAO.delete(sub));
        rutineDAO.delete(rutine);
    }
}
