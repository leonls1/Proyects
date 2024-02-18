module javafx.incidentmanager {
    requires javafx.controls;
    requires javafx.fxml;
    requires jakarta.persistence;
    requires org.hibernate.orm.core;
    requires java.xml;    
    requires java.base;   
    requires lombok;


    opens javafx.incidentmanager to javafx.fxml;
    opens javafx.incidentmanager.model.entity;
    opens javafx.incidentmanager.controller;
    
    exports javafx.incidentmanager;
    exports javafx.incidentmanager.model.entity;
    exports javafx.incidentmanager.model.enums;
    exports javafx.incidentmanager.controller;
    exports javafx.incidentmanager.service;
}
