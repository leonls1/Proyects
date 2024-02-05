package javafx.incidentmanager.model.dao;

import jakarta.persistence.EntityManager;
import java.util.List;
import javafx.incidentmanager.model.entity.Notification;

public interface NotificationDao {

    public void create(Notification notification);

    public void update(Notification notification);

    public void findById(Long id);

    public void delete(Notification notification);
    
    public List<Notification> GetAll();

    public void setEntityManager(EntityManager em);
    
}
