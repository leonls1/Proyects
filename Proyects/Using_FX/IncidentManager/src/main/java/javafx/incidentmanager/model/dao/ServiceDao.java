package javafx.incidentmanager.model.dao;

import jakarta.persistence.EntityManager;
import java.util.List;
import javafx.incidentmanager.model.entity.Service;

public interface ServiceDao {

    public void create(Service service);

    public void update(Service service);

    public void findById(Long id);

    public void delete(Service service);
    
    public List<Service> GetAll();

    public void setEntityManager(EntityManager em);
    
}
