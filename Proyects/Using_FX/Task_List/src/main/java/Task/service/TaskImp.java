package Task.service;

import Task.model.Task;
import Task.model.TaskType;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import java.util.List;

public class TaskImp implements TaskDao {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistence-unit");
    EntityManager em = emf.createEntityManager();

    @Override
    public void create(Task task) {
        
        em.getTransaction().begin();
        em.persist(task);
        em.getTransaction().commit();
     
    }

    @Override
    public void update(Task task) {
        em.getTransaction().begin();
        em.merge(task);
        em.getTransaction().commit();
        
    }

    @Override
    public Task read(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Task task) {
        Task t = em.merge(task);
        em.remove(t);
        
    }

    @Override
    public void setEntityManager(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<Task> getAll() {
        try {

            em.getTransaction().begin();

            String jpql = "SELECT t FROM Task t";
            Query query = em.createQuery(jpql, Task.class);
            List<Task> listaDeEntidades = query.getResultList();

            em.getTransaction().commit();
           

            return listaDeEntidades;
        } catch (Exception e) {
            e.printStackTrace();

        }
        return null;
    }
}
