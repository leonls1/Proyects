module project.commandmanager {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;
    requires jakarta.persistence;
    requires lombok;

    opens project.commandmanager to javafx.fxml;
    opens project.commandmanager.controller;
    opens project.commandmanager.model;
    
    exports project.commandmanager;
}
