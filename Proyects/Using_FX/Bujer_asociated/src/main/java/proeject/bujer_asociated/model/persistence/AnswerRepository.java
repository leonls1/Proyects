package proeject.bujer_asociated.model.persistence;

import jakarta.persistence.EntityManager;
import proeject.bujer_asociated.model.entities.Answer;

import java.util.List;

public class AnswerRepository {
    private final EntityManager em;

    public AnswerRepository(EntityManager em) {
        this.em = em;
    }

    public void createAnswer(Answer ans) {
        em.getTransaction().begin();
        em.persist(ans);
        em.getTransaction().commit();
    }

    public List<Answer> getAllAnswer() {
        return em.createQuery("SELECT a FROM Answer a", Answer.class).getResultList();
    }

    public Answer findById(Long id) {
        return em.find(Answer.class, id);
    }

    public void updateAnswer(Answer answer) {
        em.getTransaction().begin();
        em.merge(answer);
        em.getTransaction().commit();
    }

    public void deleteAnswer(Answer answer){
        em.getTransaction().begin();
        em.remove(answer);
        em.getTransaction().commit();
    }
}
