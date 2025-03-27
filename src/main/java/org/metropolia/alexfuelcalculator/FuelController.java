package org.metropolia.alexfuelcalculator;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class FuelController {
    @FXML
    private TextField distanceTextField, fuelTextField;
    @FXML
    private Button buttonCalculate;
    @FXML
    private Label labelResult;
    public void initialize(){
        buttonCalculate.setOnAction(event -> {
            try
            {
                double distance = Double.parseDouble(distanceTextField.getText());
                double fuel = Double.parseDouble(fuelTextField.getText());
                if(distance < 0 || fuel < 0)
                {
                    labelResult.setText("Result: N/A" );
                }
                labelResult.setText("Result: " + String.format("%.2f", fuel/distance * 100) + "l/100km");
            }catch (NumberFormatException e)
            {
                labelResult.setText("Result: N/A" );
            }
            finally {
                distanceTextField.clear();
                fuelTextField.clear();
            }
        });

    }
}