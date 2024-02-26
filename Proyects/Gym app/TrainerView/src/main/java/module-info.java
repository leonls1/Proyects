module project.trainerview {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;
    

    opens project.trainerview to javafx.fxml;
    opens project.trainerview.controller;
    
    exports project.trainerview;
}
