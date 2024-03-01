module project.trainerview {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;
    requires java.base;
    requires jakarta.persistence;
    requires lombok;
    requires org.hibernate.orm.core;
    

    opens project.trainerview to javafx.fxml;
    opens project.trainerview.controller;
    opens project.trainerview.model.entities;
    
    exports project.trainerview;
}
