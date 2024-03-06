module project.mavenproject1 {
    requires javafx.controls;
    requires javafx.fxml;

    opens project.mavenproject1 to javafx.fxml;
    exports project.mavenproject1;
}
