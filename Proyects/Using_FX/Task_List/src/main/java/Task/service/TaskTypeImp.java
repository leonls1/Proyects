package Task.service;

import Task.model.TaskType;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import java.util.List;

public class TaskTypeImp implements TaskTypeDao {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistence-unit");
    EntityManager em = emf.createEntityManager();

    @Override
    public List<TaskType> getAll() {
        try {
            em.getTransaction().begin();
            String jpql = "SELECT t FROM TaskType t";
            Query query = em.createQuery(jpql, TaskType.class);
            List<TaskType> list = query.getResultList();

            em.getTransaction().commit();
            return list;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }

    @Override
    public TaskType getById(Long id) {
        em.getTransaction().begin();
        TaskType type = em.find(TaskType.class, id);
        em.getTransaction().commit();

        return type;

    }

    @Override
    public void create(TaskType type) {
        em.getTransaction().begin();
        em.persist(type);
        em.getTransaction().commit();

    }

    @Override
    public void update(TaskType type) {
        em.getTransaction().begin();
        em.merge(type);
        em.getTransaction().commit();
    }

    @Override
    public void delete(TaskType type) {
        em.getTransaction().begin();
        TaskType t = em.merge(type);
        em.remove(t);
        em.getTransaction().commit();

    }

    @Override
    public void setEntityManager(EntityManager em) {
        this.em = em;
    }

}
