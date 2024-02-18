package javafx.incidentmanager.service;

import java.util.List;
import java.util.stream.Collectors;
import javafx.incidentmanager.model.dao.EmployeeDao;
import javafx.incidentmanager.model.entity.Employee;
import javafx.incidentmanager.model.entity.Specialty;
import javafx.incidentmanager.model.enums.EmployeeType;
import javafx.incidentmanager.utilities.factories.DAOFactory;

public class TechService {

    EmployeeDao empService;

    public TechService() {
        empService = DAOFactory.getEmployeeDao();
    }

    public List<Employee> getAllTechs() {
        List<Employee> list = empService.
                GetAll().
                stream().
                filter(emp -> emp.getEmployeeType() == EmployeeType.TECHNICIAN).
                collect(Collectors.toList());
        
        return list;
    }
    
    /*Quién fue el técnico con más incidentes resueltos en los últimos N días
○ Quién fue el técnico con más incidentes resueltos de una determinada
especialidad en los últimos N días
○ Quién fue el técnico que más rápido resolvió los incidentes
*/
    public Employee getTechMoreIncidentsSolvcedInNDays(int days){
        Employee tech = new Employee(); 
        
        //getAllTechs().
        
        return tech;
    }
    
    public Employee getTechMoreIncidentsSolvcedInNDaysAndSpecialty(int days, Specialty specialty){
        Employee tech = tech = new Employee(); 
        
        //getAllTechs().
        
        return tech;
    }
    
    public Employee getFasterSolvingTech(){
        Employee tech = tech = new Employee(); 
        
        //getAllTechs().
        
        return tech;
    }

}
