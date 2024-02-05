package javafx.incidentmanager.model.dao;

import jakarta.persistence.EntityManager;
import java.util.List;
import javafx.incidentmanager.model.entity.Incident;

public interface IncidentDao {

    public void create(Incident incident);

    public void update(Incident incident);

    public void findById(Long id);

    public void delete(Incident incident);
    
    public List<Incident> GetAll();

    public void setEntityManager(EntityManager em);
    
}
