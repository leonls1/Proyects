package project.trainerview.model.persistence;

import jakarta.persistence.EntityManager;
import java.util.List;
import project.trainerview.model.entities.User;

public interface UserDAO {
   public void create(User user);

    public void delete(User user);

    public User getById(Long id);

    public void update(User user);

    public List<User> getAll();
    
    public void setEntityManager(EntityManager em);
    
    public boolean existsByid(Long id);

}
