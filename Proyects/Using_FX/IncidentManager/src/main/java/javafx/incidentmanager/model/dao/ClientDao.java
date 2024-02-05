package javafx.incidentmanager.model.dao;

import jakarta.persistence.EntityManager;
import java.util.List;
import javafx.incidentmanager.model.entity.Client;

public interface ClientDao {

    public void create(Client client);

    public void update(Client client);

    public void findById(Long id);

    public void delete(Client client);
    
    public List<Client > GetAll();

    public void setEntityManager(EntityManager em);
    
}
