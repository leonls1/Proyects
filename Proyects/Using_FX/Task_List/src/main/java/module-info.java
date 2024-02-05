module Task {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;
    requires jakarta.persistence;
    requires org.hibernate.orm.core;
    requires java.xml;
    

    opens Task to javafx.fxml;
    opens Task.controller to javafx.fxml;
    opens Task.model;
  
   
    exports Task;
    exports Task.model;
    exports Task.controller;
    exports Task.utilities;

    
}
