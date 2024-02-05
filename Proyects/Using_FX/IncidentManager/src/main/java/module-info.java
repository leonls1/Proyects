module javafx.incidentmanager {
    requires javafx.controls;
    requires javafx.fxml;
    requires jakarta.persistence;
    requires org.hibernate.orm.core;
    requires java.xml;    
    requires java.base;   
    requires lombok;


    opens javafx.incidentmanager to javafx.fxml;
    
    exports javafx.incidentmanager;
    exports javafx.incidentmanager.model.entity;
    exports javafx.incidentmanager.model.satellite;
}
