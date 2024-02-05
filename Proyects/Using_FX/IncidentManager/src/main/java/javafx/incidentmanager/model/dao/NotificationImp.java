package javafx.incidentmanager.model.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import java.util.List;
import javafx.incidentmanager.model.entity.Notification;

public class NotificationImp implements NotificationDao {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("IncendetManager-unit");
    EntityManager em = emf.createEntityManager();

    @Override
    public void setEntityManager(EntityManager em) {
        this.em = em;
    }

    @Override
    public void create(Notification notification) {
        em.getTransaction().begin();
        em.persist(notification);
        em.getTransaction().commit();
    }

    @Override
    public void update(Notification notification) {
        em.getTransaction().begin();
        em.merge(notification);
        em.getTransaction().commit();
    }

    @Override
    public void findById(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Notification notification) {
        em.getTransaction().begin();
        Notification n = em.merge(notification);
        em.remove(n);
        em.getTransaction().commit();
    }

    @Override
    public List<Notification> GetAll() {
        em.getTransaction().begin();
        String jpql = "SELECT n FROM Notification n";
        Query query = em.createQuery(jpql, Notification.class);
        em.getTransaction().commit();
        return query.getResultList();
    }
}
