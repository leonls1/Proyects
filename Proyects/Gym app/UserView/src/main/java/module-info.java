module project.userview {
    requires javafx.controls;
    requires javafx.fxml;
    requires jakarta.persistence;
    requires lombok;
    requires org.hibernate.orm.core;

    opens project.userview to javafx.fxml;
    opens project.userview.controller;
    exports project.userview;
}
