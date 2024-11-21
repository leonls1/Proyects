package proeject.bujer_asociated;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import proeject.bujer_asociated.model.entities.Answer;
import proeject.bujer_asociated.model.entities.Question;
import proeject.bujer_asociated.model.persistence.AnswerRepository;
import proeject.bujer_asociated.model.persistence.QuestionRepository;

import java.io.IOException;
import java.util.List;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Stage stage;
    private static Scene scene;
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("bujer_asociated");
    private static EntityManager em = emf.createEntityManager();
    public static QuestionRepository questionRepository = new QuestionRepository(em);
    public static AnswerRepository answerRepository = new AnswerRepository(em);

    //public static List<Answer> answerList = answerRepository.getAllAnswer();
    public static ObservableList<Answer> answerList = FXCollections.observableArrayList(
            answerRepository.getAllAnswer());

    //public static List<Question> questionList = questionRepository.findAllQuestion();
    public static ObservableList<Question> questionList = FXCollections.observableArrayList(
       questionRepository.findAllQuestion()) ;



    @Override
    public void start(Stage stage) throws IOException {
        App.stage = stage;
        scene = new Scene(loadFXML("Main"), 650, 635);
        App.stage.setTitle("Bujer y asociados");
        App.stage.setResizable(false);

        App.stage.setScene(scene);
        App.stage.show();
    }

    public static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    public static void setRoot(String fxml, double width, double height) throws IOException {
        scene.setRoot(loadFXML(fxml));
        stage.setWidth(width);
        stage.setHeight(height);
        stage.centerOnScreen();

    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }

}