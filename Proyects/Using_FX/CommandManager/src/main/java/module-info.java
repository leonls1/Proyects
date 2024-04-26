module project.commandmanager {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens project.commandmanager to javafx.fxml;
    opens project.commandmanager.controller;
    opens project.commandmanager.model;
    
    exports project.commandmanager;
}
