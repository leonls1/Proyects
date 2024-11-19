package proeject.bujer_asociated.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import proeject.bujer_asociated.model.entities.Answer;
import proeject.bujer_asociated.model.entities.Question;

import java.net.URL;
import java.util.ResourceBundle;

public class CRUDController implements Initializable {

    @FXML
    private Button btnClearAnswer, btnClearQuestion, btnCreateAnswer, btnCreateQuestion, btnDeleteAnswer, btnDeleteQuestion, btnEditAnswer, btnEditQuestion, btnPrincipal;

    @FXML
    private ComboBox<?> cboAnswerQuestion;

    @FXML
    private TableColumn colAnswerCode, colAnswerDescription, colAnswerId, colQuestionDesc, colQuestionFK, colQuestionId;

    @FXML
    private TableView<Answer> tableAnswer;

    @FXML
    private TableView<Question> tableQuestion;

    @FXML
    private TextArea txtAQuestion, txtAnswer;

    @FXML
    private TextField txtFAnswerCode;

    @FXML
    void btnEvent(ActionEvent event) {

    }

    @FXML
    void cboEvent(ActionEvent event) {

    }

    @FXML
    void mouseEvent(MouseEvent event) {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
