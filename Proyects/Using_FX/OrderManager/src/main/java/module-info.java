module proyects.ordermanager {
    requires javafx.controls;
    requires javafx.fxml;

    opens proyects.ordermanager to javafx.fxml;
    exports proyects.ordermanager;
}
