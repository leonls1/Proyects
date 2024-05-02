package project.commandmanager.model.persistence;

import jakarta.persistence.EntityManager;
import java.util.List;
import project.commandmanager.model.entities.Command;

public interface CommandDAO {

    public void create(Command command);
    
    public void update(Command command);
    
    public void delete(Command command);
    
    public Command getById(Long id);
    
    public List<Command> getAll();
    
    public void setEntityManager(EntityManager em);
}
