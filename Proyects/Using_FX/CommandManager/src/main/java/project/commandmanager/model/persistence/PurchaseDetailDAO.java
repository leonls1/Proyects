package project.commandmanager.model.persistence;

import jakarta.persistence.EntityManager;
import java.util.List;
import project.commandmanager.model.entities.PurchaseDetail;

public interface PurchaseDetailDAO {

    public void create(PurchaseDetail detail);

    public void update(PurchaseDetail detail);

    public void delete(PurchaseDetail detail);

    public PurchaseDetail getById(Long id);

    public List<PurchaseDetail> getAll();

    public void setEntityManager(EntityManager em);
}
