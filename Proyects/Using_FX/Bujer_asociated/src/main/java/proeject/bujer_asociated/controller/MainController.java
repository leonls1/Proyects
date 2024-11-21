package proeject.bujer_asociated.controller;

import javafx.collections.FXCollections;
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

import java.io.IOException;
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
        } else if (evt.equals(btnCRUD)) {
            try {
                App.setRoot("CRUD_Bujer", 1145, 690);
            } catch (IOException e) {
                System.out.println("the view couldn't be loaded");
            }
        }
    }

    @FXML
    void cboEvent(ActionEvent event) {
        if (event.getSource().equals(cboQuestion)) {
            //refreshCbo();
            Question selectedQuestion = cboQuestion.getSelectionModel().getSelectedItem();
            if (selectedQuestion != null) {
                cboQuestion.getEditor().clear();
                List<Answer> answers = selectedQuestion.getAnswers();


                try {
                    txtA1.setText(!answers.isEmpty() ? answers.get(0).toString() : "");
                    txtA2.setText(answers.size() > 1 ? answers.get(1).toString() : "");
                    txtA3.setText(answers.size() > 2 ? answers.get(2).toString() : "");
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

        for (Question question : App.questionList) {
            if (question.getDescription().toLowerCase().contains(searchText) ||
                    String.valueOf(question.getId()).contains(searchText)) {
                filteredQuestions.add(question);
            }
        }
        cboQuestion.setItems(filteredQuestions);

        cboQuestion.getEditor().clear();
        cboQuestion.show();
    }

    private void loadCbo() {
        // setting the converter
        cboQuestion.setConverter(new QuestionConverter(cboQuestion));
        cboQuestion.setItems(App.questionList);
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
