module project.userview {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;
    requires jakarta.persistence;
    requires lombok;
    requires org.hibernate.orm.core;

    opens project.userview to javafx.fxml;
    opens project.userview.controller;
    opens project.userview.model.entities;
    
    exports project.userview;
}
