package proeject.bujer_asociated.controller;

import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import proeject.bujer_asociated.App;
import proeject.bujer_asociated.model.entities.Answer;
import proeject.bujer_asociated.model.entities.Question;
import proeject.bujer_asociated.utils.PopUp;
import proeject.bujer_asociated.utils.QuestionIDConverter;

import java.io.IOException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.ResourceBundle;

import static proeject.bujer_asociated.App.*;

public class CRUDController implements Initializable {
    @FXML
    private ComboBox<Question> cboAnswerQuestion;

    @FXML
    private TableColumn colAnswerCode, colAnswerDescription, colAnswerId, colQuestionDesc, colQuestionId;

    @FXML
    private TableColumn<Answer, Long> colQuestionFK;

    @FXML
    private TableView<Answer> tableAnswer;

    @FXML
    private TableView<Question> tableQuestion;

    @FXML
    private TextArea txtAQuestion, txtAnswer;

    @FXML
    private TextField txtFAnswerCode;

    @FXML
    private Button btnClearAnswer, btnClearQuestion, btnCreateAnswer, btnCreateQuestion, btnDeleteAnswer,
            btnDeleteQuestion, btnEditAnswer, btnEditQuestion, btnBackMain;

    private Question questionSelected;

    private Answer answerSelected;

    @FXML
    void btnEvent(ActionEvent event) {
        Object evt = event.getSource();
        if (evt.equals(btnClearAnswer)) {
            disableAnswerEdit();
        } else if (evt.equals(btnCreateAnswer)) {
            createAnswer();

        } else if (evt.equals(btnClearQuestion)) {
            disableQuestionEdit();
            txtAQuestion.setText("");

        } else if (evt.equals(btnCreateQuestion)) {
            createQuestion();

        } else if (evt.equals(btnDeleteAnswer)) {
            deleteAnswer();

        } else if (evt.equals(btnDeleteQuestion)) {
            deleteQuestion();

        } else if (evt.equals(btnEditAnswer)) {
            updateAnswer();
        } else if (evt.equals(btnEditQuestion)) {
            updateQuestion();
        } else if (evt.equals(btnBackMain)) {
            try {

                App.setRoot("Main", 650, 635);
            } catch (IOException e) {
                System.out.println("The scene couldn't be loaded");
            }
        }
    }

    @FXML
    void cboEvent(ActionEvent event) {
        if (event.getSource().equals(cboAnswerQuestion)) {
            // questionIdSelected = cboAnswerQuestion.getSelectionModel().getSelectedItem().getId();
        }
    }

    @FXML
    void mouseEvent(MouseEvent event) {
        Object evt = event.getSource();
        if (evt.equals(tableAnswer)) {

            answerSelected = tableAnswer.getSelectionModel().getSelectedItem();
            if (answerSelected != null) {
                enableAnswerEdit();
            }


        } else if (evt.equals(tableQuestion)) {

            questionSelected = tableQuestion.getSelectionModel().getSelectedItem();
            if (questionSelected != null) {
                enableQuestionEdit();
            }

        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        loadAnswerTable();
        loadQuestionTable();
        loadCBO();
    }

    //--------------------------CRUD Question-------------------------
    private void deleteQuestion() {
        questionRepository.deleteQuestion(questionSelected);
        questionList.remove(questionSelected);


        Iterator<Answer> iterator = questionSelected.getAnswers().iterator();
        while (iterator.hasNext()) {
            Answer answer = iterator.next();
            answerList.remove(answer);
            iterator.remove(); // Elimina el elemento de la lista questionSelected.getAnswers()
        }

        tableAnswer.refresh();
        tableQuestion.refresh();
        loadCBO();
        disableQuestionEdit();
    }

    private void createQuestion() {
        Question question = new Question();
        question.setDescription(txtAQuestion.getText());
        questionRepository.createQuestion(question);
        txtAQuestion.setText("");
        questionList.add(question);
        tableQuestion.refresh();
        loadCBO();

    }

    private void updateQuestion() {


        questionSelected.setDescription(txtAQuestion.getText());
        questionRepository.updateQuestion(questionSelected);
        txtAQuestion.setText("");

        tableQuestion.refresh();
        loadCBO();
        disableQuestionEdit();
    }

    //--------------------------CRUD Answer-------------------------
    private void deleteAnswer() {
        answerList.remove(answerSelected);
        answerSelected.getQuestion().getAnswers().remove(answerSelected);
        answerRepository.deleteAnswer(answerSelected);
        tableAnswer.refresh();
        disableAnswerEdit();

    }

    private void createAnswer() {
        Answer answer = new Answer();
        answer.setDescription(txtAnswer.getText());
        answer.setOrdering(txtFAnswerCode.getText());
        //updating ques
        if ((cboAnswerQuestion.getSelectionModel().getSelectedItem()) != null) {
            Question ques = (cboAnswerQuestion.getSelectionModel().getSelectedItem());
            answer.setQuestion(ques);

            ques.getAnswers().add(answer);

            answerRepository.createAnswer(answer);
            txtAnswer.setText("");
            txtFAnswerCode.setText("");
            answerList.add(answer);
            tableAnswer.refresh();
        } else {
            PopUp.showErrorAlert("Pregunta no seleccionada", "no ha asignado una pregunta para esta respuesta, \n porfavor seleccione una");
        }

    }

    private void updateAnswer() {
//        answerList.remove(answerSelected);
//        answerSelected.getQuestion().getAnswers().remove(answerSelected);
//        refreshAnswerTable();

        answerSelected.setDescription(txtAnswer.getText());
        answerSelected.setOrdering(txtFAnswerCode.getText());
        answerSelected.setQuestion(cboAnswerQuestion.getSelectionModel().getSelectedItem());

        //updating question
        //answerSelected.getQuestion().getAnswers().add(answerSelected);
        // answerList.add(answerSelected);

        answerRepository.updateAnswer(answerSelected);

        tableAnswer.refresh();
        disableAnswerEdit();
    }

    //--------------------------Table config---------------------------
    private void loadQuestionTable() {
        tableQuestion.setItems(FXCollections.observableArrayList(questionList));
        colQuestionId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colQuestionDesc.setCellValueFactory(new PropertyValueFactory<>("description"));
    }

    private void loadAnswerTable() {
        tableAnswer.setItems(FXCollections.observableArrayList(answerList));
        colAnswerCode.setCellValueFactory(new PropertyValueFactory<>("ordering"));
        colAnswerDescription.setCellValueFactory(new PropertyValueFactory<>("description"));
        colAnswerId.setCellValueFactory(new PropertyValueFactory<>("id"));

        //customized TableColumn for a specific parameter of the entity
        colQuestionFK.setCellValueFactory(cellData -> {
                    Answer ans = cellData.getValue();
                    return new SimpleObjectProperty<>(ans.getQuestion() != null ? ans.getQuestion().getId() : null);
                }
        );
    }

    private void loadCBO() {
        cboAnswerQuestion.getItems().setAll(questionList);
        cboAnswerQuestion.setConverter(new QuestionIDConverter());
    }

    //------------------------ Enable / Disable edition --------------------------
    private void enableQuestionEdit() {
        btnDeleteQuestion.setDisable(false);
        btnEditQuestion.setDisable(false);
        btnCreateQuestion.setDisable(true);
        //setting the values of the selected question
        txtAQuestion.setText(questionSelected.getDescription());

    }

    private void disableQuestionEdit() {
        btnDeleteQuestion.setDisable(true);
        btnEditQuestion.setDisable(true);
        btnCreateQuestion.setDisable(false);
        txtAQuestion.setText("");
        questionSelected = null;
    }

    private void enableAnswerEdit() {
        btnDeleteAnswer.setDisable(false);
        btnEditAnswer.setDisable(false);
        btnCreateAnswer.setDisable(true);
        //setting the values of the selected answer
        txtAnswer.setText(answerSelected.getDescription());
        txtFAnswerCode.setText(answerSelected.getOrdering());
        cboAnswerQuestion.setValue(answerSelected.getQuestion());
    }

    private void disableAnswerEdit() {
        btnDeleteAnswer.setDisable(true);
        btnEditAnswer.setDisable(true);
        btnCreateAnswer.setDisable(false);
        txtAnswer.setText("");
        txtFAnswerCode.setText("");
        cboAnswerQuestion.getEditor().clear();
    }

}
