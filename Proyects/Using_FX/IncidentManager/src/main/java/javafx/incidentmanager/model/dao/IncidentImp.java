package javafx.incidentmanager.model.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import java.util.List;
import javafx.incidentmanager.model.entity.Incident;

public class IncidentImp implements IncidentDao {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("IncendetManager-unit");
    EntityManager em = emf.createEntityManager();

    @Override
    public void setEntityManager(EntityManager em) {
        this.em = em;
    }

    @Override
    public void create(Incident incident) {
        em.getTransaction().begin();
        em.persist(incident);
        em.getTransaction().commit();
    }

    @Override
    public void update(Incident incident) {
        em.getTransaction().begin();
        em.merge(incident);
        em.getTransaction().commit();
    }

    @Override
    public void findById(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Incident incident) {
        em.getTransaction().begin();
        Incident in = em.merge(incident);
        em.remove(in);
        em.getTransaction().commit();
    }

    @Override
    public List<Incident> GetAll() {
        em.getTransaction().begin();
        String jpql = "SELECT i FROM Incident i";
        Query query = em.createQuery(jpql, Incident.class);
        em.getTransaction().commit();
        return query.getResultList();
    }

}
