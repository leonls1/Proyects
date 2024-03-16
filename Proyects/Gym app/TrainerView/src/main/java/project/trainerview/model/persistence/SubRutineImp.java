package project.trainerview.model.persistence;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import java.util.List;
import project.trainerview.model.entities.Rutine;
import project.trainerview.model.entities.SubRutine;

public class SubRutineImp implements SubRutineDAO {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("Trainer_persistence");
    private EntityManager em;

    @Override
    public void create(SubRutine subRutine) {
        getEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        //starting try-catch block
        try {
            SubRutine sub = em.merge(subRutine);
            em.persist(sub);
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
    public void delete(SubRutine subRutine) {
        getEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        try {
            SubRutine sub = em.merge(subRutine);
            em.remove(sub);
            em.getTransaction().commit();
            System.out.println("subrutina borrada:" + subRutine.getId());

        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
                System.out.println("error al terminar transaccion");
            } else {
                System.out.println("la transaccion nunca se inicio ");
            }
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public SubRutine getById(Long id) {
        getEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        SubRutine sub = new SubRutine();

        try {
            sub = em.find(SubRutine.class, id);
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
        return sub;
    }

    @Override
    public void update(SubRutine subRutine) {
        getEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        try {
            em.merge(subRutine);
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
    public List<SubRutine> getAll() {
        List<SubRutine> list = null;
        getEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        try {
            list = em.createQuery("SELECT s from SubRutine s ", SubRutine.class).getResultList();
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

        return list;
    }

    @Override
    public void setEntityManager(EntityManager em) {
        this.em = em;
    }

    public void getEntityManager() {
        em = emf.createEntityManager();
    }

    //to obtaing all subrutines with the id of the rutine
    @Override
    public List<SubRutine> getByRutineId(Long rutineId) {
        getEntityManager();
        
        //select c from Comentario c where c.publicacion.id = :publicacionId",
        TypedQuery<SubRutine> q = em.createQuery("select s from SubRutine s where s.rutine.id = :Idrutine",
                SubRutine.class);
        q.setParameter("Idrutine", rutineId);
        
        return q.getResultList();
        
        
    }
}
