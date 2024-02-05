module form.javafxcrud {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;
    requires java.sql;

    opens form.javafxcrud to javafx.fxml;
    opens form.javafxcrud.controller to javafx.fxml;
    
    exports form.javafxcrud;
    exports form.javafxcrud.controller;
    exports form.javafxcrud.data;
    exports form.javafxcrud.model;
}
