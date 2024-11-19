package proeject.bujer_asociated.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;
import javafx.scene.text.Text;
import proeject.bujer_asociated.App;
import proeject.bujer_asociated.model.entities.Answer;
import proeject.bujer_asociated.model.entities.Question;
import proeject.bujer_asociated.utils.QuestionConverter;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;


public class MainController implements Initializable {
    @FXML
    private Button btnCRUD, btnCopy1, btnCopy2, btnCopy3, btnSearch;

    @FXML
    private ComboBox<Question> cboQuestion;

    @FXML
    private TextArea txtA1, txtA2, txtA3;

    @FXML
    private Text txtQuestion;

    private List<Question> questions;

    private ObservableList<Question> observableArray;


    @FXML
    void btnEvent(ActionEvent event) {
        Object evt = event.getSource();
        if (evt.equals(btnCopy1)) {
            copyText(txtA1.getText());
        } else if (evt.equals(btnCopy2)) {
            copyText(txtA2.getText());
        } else if (evt.equals(btnCopy3)) {
            copyText(txtA3.getText());
        } else if (evt.equals(btnSearch)) {
            searchQuestions();
        }
    }

    @FXML
    void cboEvent(ActionEvent event) {
        if (event.getSource().equals(cboQuestion)) {
            Question selectedQuestion = cboQuestion.getSelectionModel().getSelectedItem();
            if (selectedQuestion != null) {
                cboQuestion.getEditor().clear();
                try {
                    // Llenar los campos de respuesta
                    txtA1.setText(selectedQuestion.getAnswers().size() > 0 ? selectedQuestion.getAnswers().get(0).toString() : "");
                    txtA2.setText(selectedQuestion.getAnswers().size() > 1 ? selectedQuestion.getAnswers().get(1).toString() : "");
                    txtA3.setText(selectedQuestion.getAnswers().size() > 2 ? selectedQuestion.getAnswers().get(2).toString() : "");
                } catch (ArrayIndexOutOfBoundsException ex) {
                    System.out.println("No hay más elementos para cargar en las respuestas");
                }

                // Llenar el campo de pregunta
                txtQuestion.setText(selectedQuestion.getId() + " " + selectedQuestion.getDescription());

            }

            cboQuestion.getEditor().clear();
        }
    }

    private void searchQuestions() {
        String searchText = cboQuestion.getEditor().getText().toLowerCase().trim();
        ObservableList<Question> filteredQuestions = FXCollections.observableArrayList();

        for (Question question : questions) {
            if (question.getDescription().toLowerCase().contains(searchText) ||
                    String.valueOf(question.getId()).contains(searchText)) {
                filteredQuestions.add(question);
            }
        }
        cboQuestion.setItems(filteredQuestions);


        cboQuestion.getEditor().clear(); // Limpiar el editor después de la búsqueda
        cboQuestion.show();
    }

    private void loadCbo() {
        // setting the converter
        QuestionConverter converter = new QuestionConverter(cboQuestion);
        cboQuestion.setConverter(converter);

        // test questions
        Question ques1 = new Question("pregunta 1", 1L);
        Question ques2 = new Question("pregunta 2", 2L);
        Question ques3 = new Question("pregunta 3", 3L);

        // Añadiendo respuestas
        ques1.setAnswers(List.of(new Answer(1L, 'A', "respuesta 1.A", ques1),
                new Answer(2L, 'B', "respuesta 1.B", ques1),
                new Answer(3L, 'C', "respuesta 1.C", ques1)));

        ques2.setAnswers(List.of(new Answer(4L, 'A', "respuesta 2.A", ques2),
                new Answer(5L, 'B', "respuesta 2.B", ques2),
                new Answer(6L, 'C', "respuesta 2.C", ques2)));

        ques3.setAnswers(List.of(new Answer(7L, 'A', "respuesta 3.A", ques3),
                new Answer(8L, 'B', "respuesta 3.B", ques3),
                new Answer(9L, 'C', "respuesta 3.C", ques3)));

        // Lista de preguntas
        questions = List.of(ques1, ques2, ques3);
        observableArray = FXCollections.observableArrayList(questions);
        cboQuestion.setItems(observableArray);
    }

    private void copyText(String content) {
        Clipboard clipboard = Clipboard.getSystemClipboard();
        ClipboardContent clipboardContent = new ClipboardContent();
        clipboardContent.putString(content);
        clipboard.setContent(clipboardContent);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        loadCbo();
    }

}
