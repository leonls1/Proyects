module project.trainerview {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;
    requires jakarta.persistence;
    requires lombok;
    requires org.hibernate.orm.core;
    

    opens project.trainerview to javafx.fxml;
    opens project.trainerview.controller;
    opens project.trainerview.model.entities to org.hibernate.orm.core;
    
    exports project.trainerview;
}
