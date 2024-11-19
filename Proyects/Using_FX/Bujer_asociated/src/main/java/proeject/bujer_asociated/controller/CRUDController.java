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
import proeject.bujer_asociated.App;
import proeject.bujer_asociated.model.entities.Answer;
import proeject.bujer_asociated.model.entities.Question;
import proeject.bujer_asociated.model.persistence.AnswerRepository;
import proeject.bujer_asociated.model.persistence.QuestionRepository;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CRUDController implements Initializable {
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
    private Button btnClearAnswer, btnClearQuestion, btnCreateAnswer, btnCreateQuestion, btnDeleteAnswer,
            btnDeleteQuestion, btnEditAnswer, btnEditQuestion, btnPrincipal, btnBackMain;

    private Question questionSelected;

    private Answer answerSelected;

    @FXML
    void btnEvent(ActionEvent event) {
        Object evt = event.getSource();
        if (evt.equals(btnClearAnswer)){

        }else if (evt.equals(btnCreateAnswer)){

        }else if (evt.equals(btnClearQuestion)){

        }else if (evt.equals(btnCreateQuestion)){

        }else if (evt.equals(btnDeleteAnswer)){

        }else if (evt.equals(btnDeleteQuestion)){

        }else if (evt.equals(btnEditAnswer)){

        }else if (evt.equals(btnEditQuestion)){

        }else if (evt.equals(btnPrincipal)){

        }else if (evt.equals(btnBackMain)){
            try {
                App.setRoot("Main", 650, 635);
            } catch (IOException e) {
                System.out.println("The scene couldn't be loaded");
            }
        }
    }

    @FXML
    void cboEvent(ActionEvent event) {
        if(event.getSource().equals(cboAnswerQuestion)){

        }
    }

    @FXML
    void mouseEvent(MouseEvent event) {
        Object evt = event.getSource();
        if(evt.equals(tableAnswer)){

        }else if(evt.equals(tableQuestion)){

        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    private void loadQuestionTable(){

    }

    private void loadAnswerTable(){

    }

    private void loadCBO(){

    }


}
