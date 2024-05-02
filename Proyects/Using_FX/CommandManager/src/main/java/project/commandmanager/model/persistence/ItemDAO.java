package project.commandmanager.model.persistence;

import jakarta.persistence.EntityManager;
import java.util.List;
import project.commandmanager.model.entities.Item;

public interface ItemDAO {

    public void create(Item item);
    
    public void update(Item item);
    
    public void delete(Item item);
    
    public  Item getById(Long id);
    
    public List<Item> getAll();
    
    public void setEntityManager(EntityManager em);
}
