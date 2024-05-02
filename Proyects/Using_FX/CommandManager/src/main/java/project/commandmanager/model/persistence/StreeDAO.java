package project.commandmanager.model.persistence;

import jakarta.persistence.EntityManager;
import java.util.List;
import project.commandmanager.model.entities.Street;

public interface StreeDAO {

    public void create(Street street);

    public void update(Street street);

    public void delete(Street street);

    public Street getById(Long id);

    public List<Street> getAll();

    public void setEntityManager(EntityManager em);
}
