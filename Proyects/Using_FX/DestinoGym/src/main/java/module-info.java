module project.destinogym {
    requires javafx.controls;
    requires javafx.fxml;

    opens project.destinogym to javafx.fxml;
    exports project.destinogym;
}
