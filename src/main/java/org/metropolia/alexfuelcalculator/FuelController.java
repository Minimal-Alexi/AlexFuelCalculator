package org.metropolia.alexfuelcalculator;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.Locale;
import java.util.ResourceBundle;

public class FuelController {
    private ResourceBundle messages;
    private double result;
    @FXML
    private TextField distanceTextField, fuelTextField;
    @FXML
    private Button buttonCalculate,buttonEn,buttonFr,buttonIr,buttonJp;
    @FXML
    private Label labelResult,labelFuel,labelDistance;
    public void initialize(){
        changeLanguage("en","US");
        buttonCalculate.setOnAction(event -> {
            try
            {
                double distance = Double.parseDouble(distanceTextField.getText());
                double fuel = Double.parseDouble(fuelTextField.getText());
                if(distance <= 0 || fuel <= 0)
                {
                    labelResult.setText(messages.getString("error.Null") );
                }
                else
                {
                    result = fuel/distance * 100;
                    labelResult.setText(messages.getString("labelResult") + String.format("%.2f", result) + "l/100km");
                }
            }catch (NumberFormatException e)
            {
                labelResult.setText(messages.getString("error.InvalidFormat"));
            }
            finally {
                distanceTextField.clear();
                fuelTextField.clear();
            }
        });
        buttonEn.setOnAction(event -> {
            changeLanguage("en","US");
        });
        buttonFr.setOnAction(event -> {
            changeLanguage("fr","FR");
        });
        buttonIr.setOnAction(event -> {
            changeLanguage("ir","IR");
        });
        buttonJp.setOnAction(event -> {
            changeLanguage("jp","JP");
        });

    }
    private void changeLanguage(String language,String country){
        messages = ResourceBundle.getBundle("org.metropolia.alexfuelcalculator.messages", new Locale(language, country));
        labelFuel.setText(messages.getString("labelFuel"));
        labelDistance.setText(messages.getString("labelDistance"));
        labelResult.setText(messages.getString("labelResult") + String.format("%.2f", result) + "l/100km");
    }
}