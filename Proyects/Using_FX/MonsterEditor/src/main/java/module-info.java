module javafx.monstereditor {
    requires javafx.controls;
    requires javafx.fxml;

    opens javafx.monstereditor to javafx.fxml;
    exports javafx.monstereditor;
}
