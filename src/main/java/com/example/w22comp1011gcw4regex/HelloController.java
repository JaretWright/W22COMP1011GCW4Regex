package com.example.w22comp1011gcw4regex;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {

    @FXML
    private TextField phoneNumTextField;

    @FXML
    private Label resultLabel;

    @FXML
    private Label replaceAllLabel;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        phoneNumTextField.textProperty().addListener((obs, oldValue, phoneNumber)->{
            if (phoneNumber.matches("\\(?[2-9][0-9][0-9]\\)?[-\\s.]?[2-9]\\d{2}[-\\s.]?[0-9]{4}"))
                resultLabel.setText(String.format("%s is a valid phone number",phoneNumber));
            else
                resultLabel.setText(String.format("%s is not a valid phone number",phoneNumber));

            //using replaceAll() with our String to remove special characters before the analysis
            String phoneNumJustNumbers = phoneNumber.replaceAll("[-\\s\\(\\).]","");
            replaceAllLabel.setText(String.format("Removing special characters: '%s'",phoneNumJustNumbers));
        });
    }
}
