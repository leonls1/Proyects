module project.commandmanager {
    requires javafx.controls;
    requires javafx.fxml;

    opens project.commandmanager to javafx.fxml;
    exports project.commandmanager;
}
