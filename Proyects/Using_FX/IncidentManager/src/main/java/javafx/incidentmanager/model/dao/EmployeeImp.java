package javafx.incidentmanager.model.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import java.util.List;
import javafx.incidentmanager.model.entity.Employee;

public class EmployeeImp implements EmployeeDao {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("IncendetManager-unit");
    EntityManager em = emf.createEntityManager();

    @Override
    public void setEntityManager(EntityManager em) {
        this.em = em;
    }

    @Override
    public void create(Employee empl) {
        em.getTransaction().begin();
        em.persist(empl);
        em.getTransaction().commit();
    }

    @Override
    public void update(Employee empl) {
        em.getTransaction().begin();
        em.merge(empl);
        em.getTransaction().commit();
    }

    @Override
    public void findById(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Employee empl) {
        em.getTransaction().begin();
        Employee e = em.merge(empl);
        em.remove(e);em.getTransaction().commit();
        
    }

    @Override
    public List<Employee> GetAll() {
        em.getTransaction().begin();
        String jpql = "SELECT e FROM Employee e";
        Query query = em.createQuery(jpql, Employee.class);
        em.getTransaction().commit();
        return query.getResultList();
    }
}
