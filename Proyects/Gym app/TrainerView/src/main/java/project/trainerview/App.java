package project.trainerview;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {
    
    private static Scene scene;
    private static Stage stage;
    
    @Override
    public void start(Stage stage) throws IOException {
        this.stage = stage;
        
        stage.setTitle("Gym app, Trainer view");
        stage.setResizable(false);
        
        scene = new Scene(loadFXML("Menu"));
        stage.setScene(scene);
        stage.show();
    }
    
    public static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));

    }
    
    public static void setRoot(String fxml, double width, double height) throws IOException {
        scene.setRoot(loadFXML(fxml));
        stage.setWidth(width);
        stage.setHeight(height);
        
    }
    
    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }
    
    public static void main(String[] args) {
        launch();
    }
    
}
