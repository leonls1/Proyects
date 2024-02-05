package Task.service;

import Task.model.Task;
import jakarta.persistence.EntityManager;
import java.util.List;

public interface TaskDao {
    
    public List<Task> getAll();
    
    public void create(Task task);    
    
    public void update(Task task);

    public Task read(Long id);
    
    public void delete(Task task);
    
    public void setEntityManager(EntityManager em);
    

}
