module proeject.bujer_asociated {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;
    requires jakarta.persistence;
    requires lombok;
    requires org.hibernate.orm.core;
    requires java.desktop;


    opens proeject.bujer_asociated to javafx.fxml;
    opens proeject.bujer_asociated.controller ;
    opens proeject.bujer_asociated.model.persistence;
    opens proeject.bujer_asociated.model.entities;

    exports proeject.bujer_asociated;
}
