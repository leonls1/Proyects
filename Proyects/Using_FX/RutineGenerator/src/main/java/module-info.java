module proyects.rutinegenerator {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;
    requires jakarta.persistence;
    requires java.xml;    
    requires lombok;

    opens proyects.rutinegenerator to javafx.fxml;
    opens proyects.rutinegenerator.controller;
    opens proyects.rutinegenerator.model;
    
    
    exports proyects.rutinegenerator;
    exports proyects.rutinegenerator.controller;
}
