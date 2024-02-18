package javafx.incidentmanager.utilities.factories;

import javafx.incidentmanager.model.dao.*;


public class DAOFactory {
    public static ClientDao getClientDao(){
        return new ClientImp();
    }
    
    public static EmployeeDao getEmployeeDao(){
        return new EmployeeImp();
    }
    
    public static IncidentDao getIncidentDao(){
        return new IncidentImp();
    }
    
    public static NotificationDao getNotificationDao(){
        return new NotificationImp();
    }
    
    public static ProblemDao getProblemDao(){
        return new ProblemImp();
    }
    
    public static ServiceDao getServiceDao(){
        return new ServiceImp();
    }
    
    public static SpecialtyDao getSpecialtyDao(){
        return new SpecialtyImp();
    }
}
