package javafx.incidentmanager.model.dao;

import jakarta.persistence.EntityManager;
import java.util.List;
import javafx.incidentmanager.model.entity.Employee;

public interface EmployeeDao {

    public void create(Employee empl);

    public void update(Employee empl);

    public void findById(Long id);

    public void delete(Employee empl);
    
    public List<Employee> GetAll();

    public void setEntityManager(EntityManager em);
    
   
    
}
