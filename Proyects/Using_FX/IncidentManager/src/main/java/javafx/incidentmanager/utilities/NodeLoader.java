package javafx.incidentmanager.utilities;

import javafx.incidentmanager.model.dao.*;
import javafx.incidentmanager.utilities.factories.DAOFactory;
import javafx.scene.control.ComboBox;

public class NodeLoader {

    public static void loadCBO(ComboBox cbo, String classType) {
       Object service; 
        switch (classType) {
            case "client":
                service = DAOFactory.getClientDao();
                break;

            case "employee":
                service = DAOFactory.getEmployeeDao();
                break;

            case "incident":
                service = DAOFactory.getIncidentDao();
                break;

            case "notification":
                service = DAOFactory.getNotificationDao();
                break;

            case "problem":
                service = DAOFactory.getProblemDao();
                break;

            case "service":
                service = DAOFactory.getServiceDao();
                break;

            case "specialty":
                service = DAOFactory.getServiceDao();
                break;
        }        
        
    }
}
