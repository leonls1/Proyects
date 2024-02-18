package javafx.incidentmanager;

import javafx.incidentmanager.model.enums.CorporateName;
import javafx.incidentmanager.model.enums.ContactType;
import javafx.incidentmanager.model.enums.EmployeeType;
import javafx.incidentmanager.model.enums.ProblemType;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;
import javafx.incidentmanager.model.dao.*;
import javafx.incidentmanager.model.entity.*;

public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("Main"), 640, 480);
        stage.setScene(scene);
        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();

        //testing
        ClientDao clientService = new ClientImp();
        EmployeeDao employeeService = new EmployeeImp();
        IncidentDao incidentService = new IncidentImp();
        NotificationDao notificationService = new NotificationImp();
        ProblemDao problemService = new ProblemImp();
        ServiceDao serviceService = new ServiceImp();
        SpecialtyDao specialtyService = new SpecialtyImp();

        //
        //loading basic data in the dataBase
        Client cliente1 = new Client("40662557", Long.MIN_VALUE, "Email1@gmail.com", CorporateName.EMPLEADO_EN_BLANCO);
        Client cliente2 = new Client("40655846", 77944l, "Email1@yahoo.com", CorporateName.EMPLEADO_EN_BLANCO);

        Employee empleado1 = new Employee("Leon", "Lederhos", LocalDate.EPOCH, LocalDate.MAX, 35476973l, "leonlederhos@Gmail.com", EmployeeType.TECHNICIAN);
        Employee empleado2 = new Employee("Sasha", "Lederhos", LocalDate.EPOCH, LocalDate.MAX, 35476973l, "leonlederhos@Gmail.com", EmployeeType.TECHNICIAN);
        Employee empleado3 = new Employee("Alexis", "Lederhos", LocalDate.EPOCH, LocalDate.MAX, 35476973l, "leonlederhos@Gmail.com", EmployeeType.TECHNICIAN);

        Service service1 = new Service("Servicio 1");

        Incident incident1 = new Incident(service1, cliente2, LocalDate.MAX, LocalDate.MAX, LocalDate.MIN, "un incidente muy complicado");
        Incident incident2 = new Incident(service1, cliente2, LocalDate.MAX, LocalDate.MAX, LocalDate.MIN, "otro incidente un poco mas simple");

        Notification noti1 = new Notification(incident2, "una notificacion simpaticca", ContactType.WHWATSAPP, "llame ya!");

        Problem problem1 = new Problem(incident2, ProblemType.SOFTWARE, "Desinstale el windows sin querer", 3);
        Problem problem2 = new Problem(incident2, ProblemType.SOFTWARE, "Quize instalarlo de nuevo y instale uno lleno de virus, pucha", 3);

        Specialty specialty1 = new Specialty("java");

        //making some relations between the objects
        cliente1.setIncidents(List.of(incident1, incident2));
        cliente2.setIncidents(List.of(incident1));

        incident1.setClients(cliente2);
        incident1.setClients(cliente1);
        incident2.setClients(cliente1);

        empleado1.setSpecialties((Set) List.of(specialty1));
        empleado2.setSpecialties((Set) List.of(specialty1));
        empleado3.setSpecialties((Set) List.of(specialty1));

        specialty1.setEmployees((Set) List.of(empleado1, empleado2, empleado3));

        //incident --> !notification, problems, ¡service, ¡client
        incident1.setNotifications(List.of(noti1));
        noti1.setIncident(incident1);

        incident1.setProblems(List.of(problem1, problem2));
        problem1.setIncident(incident1);
        problem2.setIncident(incident1);

        incident1.setService(service1);
        service1.setIncidents(List.of(incident1));

        //problem ¡incident ,!¡specialties
        problem1.setSpecialties((Set) List.of(specialty1));
        specialty1.setProblems((Set) List.of(problem1));
        specialty1.setProblems((Set) List.of(problem2));
        //saving data into de DB

        clientService.create(cliente2);
        clientService.create(cliente1);
        
        employeeService.create(empleado3);
        employeeService.create(empleado2);
        employeeService.create(empleado1);
        
        incidentService.create(incident2);
        incidentService.create(incident1);
        
        notificationService.create(noti1);
        
        problemService.create(problem2);
        problemService.create(problem1);
        
        serviceService.create(service1);
        
        specialtyService.create(specialty1);
        
        
        
        
        
        
        
        
        
    }

}
