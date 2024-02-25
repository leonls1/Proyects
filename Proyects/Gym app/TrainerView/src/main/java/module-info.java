module project.trainerview {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens project.trainerview to javafx.fxml;
    exports project.trainerview;
}
