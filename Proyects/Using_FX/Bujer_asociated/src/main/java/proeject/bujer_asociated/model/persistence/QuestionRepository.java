package proeject.bujer_asociated.model.persistence;

import jakarta.persistence.EntityManager;
import proeject.bujer_asociated.model.entities.Question;

import java.util.List;

public class QuestionRepository {
    private final EntityManager em;

    public QuestionRepository(EntityManager em) {
        this.em = em;
    }

    public void createQuestion(Question question){
        em.getTransaction().begin();
        em.persist(question);
        em.getTransaction().commit();
    }

    public Question findQuestionById(Long id){
        return em.find(Question.class, id);
    }

    public List<Question> findAllQuestion(){
        return em.createQuery("SELECT q from Question q", Question.class).getResultList();
    }

    public void updateQuestion(Question question){
        em.getTransaction().begin();
        em.merge(question);
        em.getTransaction().commit();
    }

    public void deleteQuestion(Question question){
        em.getTransaction().begin();
        em.remove(question);
        em.getTransaction().commit();
    }
}
