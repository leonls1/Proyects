package project.commandmanager.model.persistence;

import jakarta.persistence.EntityManager;
import java.util.List;
import project.commandmanager.model.entities.Type;

public interface TypeDAO {

    public void create(Type type);

    public void update(Type type);

    public void delete(Type type);

    public Type getById(Long id);

    public List<Type> getAll();

    public void setEntityManager(EntityManager em);
}
