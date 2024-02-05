package javafx.incidentmanager.model.dao;

import jakarta.persistence.EntityManager;
import java.util.List;
import javafx.incidentmanager.model.entity.Specialty;

public interface SpecialtyDao {

    public void create(Specialty specialty);

    public void update(Specialty specialty);

    public void findById(Long id);

    public void delete(Specialty specialty);
    
    public List<Specialty> GetAll();

    public void setEntityManager(EntityManager em);
    
}
