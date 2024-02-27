package project.trainerview.utilities.other;

import java.util.Optional;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.stage.Modality;

public class ConfirmationsValidations {

    public static boolean confirnationMessage(String message, String header, String content) {
        //Definition Popup 
        Dialog<ButtonType> dialog = new Dialog<>();
        dialog.setTitle(message);
        dialog.setHeaderText(header);
        dialog.initModality(Modality.WINDOW_MODAL);

        //Definition for the label
        Label label = new Label(content);
        dialog.getDialogPane().setContent(label);

        //definition ok and cancel buttons
        ButtonType okButton = new ButtonType("OK", ButtonBar.ButtonData.OK_DONE);
        ButtonType cancelButton = new ButtonType("CANCEL", ButtonBar.ButtonData.CANCEL_CLOSE);

        //adding buttons to the dialog
        dialog.getDialogPane().getButtonTypes().addAll(okButton, cancelButton);

        Optional<ButtonType> result = dialog.showAndWait();

        return (result.isPresent() && result.get() == okButton);
    }
    
    public static boolean notNullFields(){
        return true;
    }
}
