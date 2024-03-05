package project.userview.model.persistence;

import jakarta.persistence.EntityManager;
import java.util.List;
import project.userview.model.entities.SubRutine;

public interface SubRutineDAO {

    public void create(SubRutine subRutine);

    public void delete(SubRutine subRutine);

    public SubRutine getById(Long id);

    public void update(SubRutine subRutine);

    public List<SubRutine> getAll();
    
    public void setEntityManager(EntityManager em);

}
