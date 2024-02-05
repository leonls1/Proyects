/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package calculator.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author leon
 */
public class SimpleCalculatorController implements Initializable {

    @FXML
    private Button btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btnClear, btnPlus, btnEquals;

    @FXML
    private TextField txtShowed;

    @FXML
    private void btnAction(ActionEvent event) {
        Object evt = event.getSource();

        if (evt.equals(btn0)) {
            setText("0");

        } else if (evt.equals(btn1)) {
            setText("1");

        } else if (evt.equals(btn2)) {
            setText("2");

        } else if (evt.equals(btn3)) {
            setText("3");

        } else if (evt.equals(btn4)) {
            setText("4");

        } else if (evt.equals(btn5)) {
            setText("5");

        } else if (evt.equals(btn6)) {
            setText("6");
        } else if (evt.equals(btn7)) {
            setText("7");
        } else if (evt.equals(btn8)) {
            setText("8");
        } else if (evt.equals(btn9)) {
            setText("9");
        } else if (evt.equals(btnClear)) {
            txtShowed.setText("");

        } else if (evt.equals(btnPlus)) {
            setText("+");
        } else if (evt.equals(btnEquals)) {
            calculate();
        }
    }

    private void calculate() {
        String numbers = txtShowed.getText();
        int total = 0;
        String actualAmount = "";
        for (char number : numbers.toCharArray()) {
            if (!Character.isDigit(number)) {
                if (number == '+') {
                    total += Integer.parseInt(actualAmount.trim());
                    actualAmount= "";
                    
                }//else if(number == '=')
            }
        actualAmount += number;
        }
        txtShowed.setText( String.valueOf(total));
    }

    private void setText(String symbol) {
        txtShowed.setText(txtShowed.getText() + symbol);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
