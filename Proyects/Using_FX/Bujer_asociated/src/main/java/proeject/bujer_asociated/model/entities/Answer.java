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

    private String ordering;

    private String description;

    @ManyToOne(cascade = CascadeType.ALL)
    private Question question;

    public Answer(Long id, String order, String description, Question question) {
        this.id = id;
        this.ordering = order;
        this.description = description;
        this.question = question;
        question.getAnswers().add(this);
    }

    public Answer() {
    }

    @Override
    public String toString(){
        return ordering + " " + description;
    }
}
