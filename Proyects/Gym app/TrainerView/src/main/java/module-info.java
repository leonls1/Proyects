module project.trainerview {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;
    requires jakarta.persistence;
    requires lombok;
    requires java.xml;

    opens project.trainerview to javafx.fxml;
    opens project.trainerview.controller;
    
    exports project.trainerview;
}
