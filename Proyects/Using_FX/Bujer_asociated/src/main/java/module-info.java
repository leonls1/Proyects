module proeject.bujer_asociated {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;
    requires jakarta.persistence;
    requires lombok;
    requires org.hibernate.orm.core;
    requires java.desktop;


    opens proeject.bujer_asociated to javafx.fxml;
    opens proeject.bujer_asociated.controller to javafx.fxml;
    opens proeject.bujer_asociated.model.entities to javafx.fxml;

    exports proeject.bujer_asociated;
}
