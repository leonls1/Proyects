package proeject.bujer_asociated.model.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Answer {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;

    private String order;

    private String description;

    @ManyToOne
    private Question question;

    public Answer(Long id, String order, String description, Question question) {
        this.id = id;
        this.order = order;
        this.description = description;
        this.question = question;
        question.getAnswers().add(this);
    }

    public Answer() {
    }

    @Override
    public String toString(){
        return order + " " + description;
    }
}
