package javafx.incidentmanager.model.dao;

import jakarta.persistence.EntityManager;
import java.util.List;
import javafx.incidentmanager.model.entity.Problem;

public interface ProblemDao {

    public void create(Problem problem);

    public void update(Problem problem);

    public void findById(Long id);

    public void delete(Problem problem);
    
    public List<Problem> GetAll();

    public void setEntityManager(EntityManager em);
    
}
