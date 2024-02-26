package project.trainerview.model.persistence;

import jakarta.persistence.EntityManager;
import java.util.List;
import project.trainerview.model.entities.Rutine;

public interface RutineDAO {
   public void create(Rutine rutine);

    public void delete(Rutine rutine);

    public Rutine getdById();

    public void update(Rutine rutine);

    public List<Rutine> getAll();
    
    public void setEntityManager(EntityManager em);

}
