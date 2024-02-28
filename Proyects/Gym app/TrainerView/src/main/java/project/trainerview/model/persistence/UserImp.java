package project.trainerview.model.persistence;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import java.util.List;
import project.trainerview.model.entities.SubRutine;
import project.trainerview.model.entities.User;

public class UserImp implements UserDAO {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("Trainer_persistence");
    private EntityManager em;

    @Override
    public void create(User user) {
        getEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        //starting try-catch block
        try {
            em.persist(user);
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
    public void delete(User user) {
        getEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        try {
            User us = em.merge(user);
            em.remove(us);
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
    public User getById(Long id) {
        getEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        User us = new User();

        try {
            us = em.find(User.class, id);
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
        return us;
    }

    @Override
    public void update(User user) {
        getEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        try {
            em.merge(user);
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
    public List<User> getAll() {
        List<User> list = null;
        getEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        try {
            System.out.println("obtenidos los usuarios");
            list = em.createQuery("SELECT u from User u", User.class).getResultList();
            em.getTransaction().commit();
            
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
                e.printStackTrace();
            }
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

    public void getEntityManager() {
        em = emf.createEntityManager();
    }

    @Override
    public boolean existsByid(Long id) {
        return getById(id) == null;
    
    }

}
