package proeject.bujer_asociated.utils;


import javafx.scene.control.ComboBox;
import javafx.util.StringConverter;
import proeject.bujer_asociated.model.entities.Question;

public class QuestionConverter extends StringConverter<Question> {
    private ComboBox<Question> comboBox;

    public QuestionConverter(ComboBox<Question> comboBox) {
        this.comboBox = comboBox;
    }

    //    public void setConverterCBO(ComboBox<?> comboBox) {
//        // Configurar cómo se muestra el objeto seleccionado
//        comboBox.setConverter(new StringConverter<Object>() {
//            @Override
//            public String toString(Object object) {
//                return object == null ? "" : ((Question) object).getDescription();
//            }
//
//            @Override
//            public Object fromString(String string) {
//                return null;
//            }
//        });
//    }

    @Override
    public String toString(Question question) {
        return question== null ? "" : question.getDescription();
    }

    @Override
    public Question fromString(String string) {
        return comboBox.getSelectionModel().getSelectedItem();
    }
}
