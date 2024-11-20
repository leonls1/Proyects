package proeject.bujer_asociated.utils;

import javafx.util.StringConverter;
import proeject.bujer_asociated.model.entities.Question;

public class QuestionIDConverter extends StringConverter<Question> {
    @Override
    public String toString(Question question) {
        return question != null ? question.getId().toString() : "";
    }

    @Override
    public Question fromString(String string) {
        return null;
    }
}
