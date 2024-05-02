package project.commandmanager.model.persistence;

import jakarta.persistence.EntityManager;
import java.util.List;
import project.commandmanager.model.entities.Purchase;

public interface PurchaseDAO {

    public void create(Purchase purchase);

    public void update(Purchase purchase);

    public void delete(Purchase purchase);

    public Purchase getById(Long id);

    public List<Purchase> getAll();

    public void setEntityManager(EntityManager em);
}
