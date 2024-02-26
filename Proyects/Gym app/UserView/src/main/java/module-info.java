module project.userview {
    requires javafx.controls;
    requires javafx.fxml;

    opens project.userview to javafx.fxml;
    opens project.userview.controller;
    exports project.userview;
}
