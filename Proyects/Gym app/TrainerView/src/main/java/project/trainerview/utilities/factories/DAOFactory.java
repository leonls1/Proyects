package project.trainerview.utilities.factories;

import project.trainerview.model.persistence.RutineDAO;
import project.trainerview.model.persistence.RutineImp;
import project.trainerview.model.persistence.SubRutineDAO;
import project.trainerview.model.persistence.SubRutineImp;
import project.trainerview.model.persistence.UserDAO;
import project.trainerview.model.persistence.UserImp;


public class DAOFactory {
    public static RutineDAO geRutineDAO(){
        return new RutineImp();
    }
    
    public static SubRutineDAO geSubRutineDAO(){
        return  new SubRutineImp();
    }
    
    public static UserDAO geUserDAO(){
        return new UserImp();
    }
}
