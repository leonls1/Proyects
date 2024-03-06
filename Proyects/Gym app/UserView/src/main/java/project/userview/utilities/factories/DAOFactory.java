package project.userview.utilities.factories;

import project.userview.model.persistence.RutineDAO;
import project.userview.model.persistence.RutineImp;
import project.userview.model.persistence.SubRutineDAO;
import project.userview.model.persistence.SubRutineImp;
import project.userview.model.persistence.UserDAO;
import project.userview.model.persistence.UserImp;


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
