module calculator {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens calculator to javafx.fxml;
    opens calculator.controller;
    exports calculator;
    exports calculator.controller;
    
}
