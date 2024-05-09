package project.commandmanager.model.persistence;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import java.util.List;
import project.commandmanager.model.entities.Purchase;

public class PurchaseImp implements PurchaseDAO {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("command_manager_persitence");
    EntityManager em;

    @Override
    public void create(Purchase purchase) {
        getEntityManager();
        EntityTransaction transaction = em.getTransaction();

        transaction.begin();

        try {
            em.persist(purchase);
            transaction.commit();

        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }

        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public void update(Purchase purchase) {
        getEntityManager();
        EntityTransaction transaction = em.getTransaction();

        transaction.begin();

        try {
            em.merge(purchase);
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }

        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public void delete(Purchase purchase) {
        getEntityManager();
        EntityTransaction transaction = em.getTransaction();

        transaction.begin();

        try {
            Purchase p = em.merge(purchase);
            em.remove(p);
            transaction.commit();

        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public Purchase getById(Long id) {

        getEntityManager();
        Purchase p = new Purchase();
        try {
            p = em.find(Purchase.class, id);
        } finally {
            if (em != null) {
                em.close();
            }
        }

        return p;
    }

    @Override
    public List<Purchase> getAll() {
        List<Purchase> list = null;
        getEntityManager();

        try {
            list = em.createQuery("Select p From Purchase", Purchase.class).getResultList();

        } finally {

            if (em != null) {
                em.close();
            }
        }

        return list;
    }

    @Override
    public void setEntityManager(EntityManager em) {
        this.em = em;
    }

    private void getEntityManager() {
        this.em = emf.createEntityManager();
    }

}
