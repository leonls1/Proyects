module project.userview {
    requires javafx.controls;
    requires javafx.fxml;

    opens project.userview to javafx.fxml;
    exports project.userview;
}
