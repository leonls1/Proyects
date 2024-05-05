package project.commandmanager.model.persistence;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import java.util.List;
import project.commandmanager.model.entities.Command;

public class CommandImp implements CommandDAO {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("command_manager_persitence");
    EntityManager em;

    @Override
    public void create(Command command) {
        getEntityManager();
        EntityTransaction transaction = em.getTransaction();

        try {
            transaction.begin();
            em.persist(command);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }

        } finally {
            if (em != null) {
                em.close();
            }

        }
    }

    @Override
    public void update(Command command) {
        getEntityManager();
        EntityTransaction transaction = em.getTransaction();

        try {
            transaction.begin();
            em.persist(command);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }

        } finally {
            if (em != null) {
                em.close();
            }

        }
    }

    @Override
    public void delete(Command command) {
        getEntityManager();
        EntityTransaction transaction = em.getTransaction();

        try {
            transaction.begin();
            Command c = em.merge(command);
            em.remove(c);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }

        } finally {
            if (em != null) {
                em.close();
            }

        }
    }

    @Override
    public Command getById(Long id) {
        getEntityManager();
        EntityTransaction transaction = em.getTransaction();

        try {
            transaction.begin();

            transaction.commit();
        } catch (Exception e) {
           if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }

        } finally {
            if (em != null) {
                em.close();
            }

        }
    }

    @Override
    public List<Command> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void setEntityManager(EntityManager em) {
        this.em = em;
    }

    private void getEntityManager() {
        this.em = emf.createEntityManager();
    }

}
