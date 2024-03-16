package project.trainerview.model.persistence;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import java.util.List;
import project.trainerview.model.entities.Rutine;

public class RutineImp implements RutineDAO {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("Trainer_persistence");
    private EntityManager em;

    public RutineImp() {
    }

    public RutineImp(EntityManager em) {
        this.em = em;
    }

    @Override
    public void create(Rutine rutine) {
        getEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        //starting try-catch block
        try {

            em.persist(rutine);
            em.getTransaction().commit();
        } catch (Exception e) {
            //if the transaction still active it will rollback 
            if (transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            //always the entity manager will be closed, if it isn't null
            if (em != null) {
                em.close();
            }
        }

    }

    @Override
    public void delete(Rutine rutine) {
        getEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        try {
            Rutine r = em.merge(rutine);
            em.remove(r);
            em.getTransaction().commit();

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
    public Rutine getdById(Long id) {
        getEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        Rutine r = new Rutine();

        try {
            r = em.find(Rutine.class, id);
            em.getTransaction().commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
        } finally {
            if (em != null) {
                em.close();

            }
        }
        return r;
    }

    @Override
    public void update(Rutine rutine) {
        getEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        try {
            em.merge(rutine);
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
    public List<Rutine> getAll() {
        List<Rutine> list = null;
        getEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        try {         
            
            list = em.createQuery("SELECT r from Rutine r ", Rutine.class).getResultList();
            em.getTransaction().commit();
        } catch (Exception e) {
            if(transaction.isActive()){
                transaction.rollback();
            }
        } finally {
            if(em!= null){
                em.close();
            }
        }

        return list;
    }

    @Override
    public void setEntityManager(EntityManager em) {
        this.em = em;
    }

    public void getEntityManager() {
        em = emf.createEntityManager();
    }

}
