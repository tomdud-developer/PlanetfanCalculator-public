package com.planetfan.planetfancalculator.measure.power;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

import java.net.URL;
import java.text.DecimalFormat;
import java.util.ResourceBundle;

public class PowerTabController implements Initializable {

    @FXML TextField NzField;
    @FXML TextField IzField;
    @FXML TextField UzField;

    @FXML TextField IField;
    @FXML TextField UField;

    @FXML TextField NField;


    public PowerTabController() {}

    @FXML
    public void calc() {
        try {
            double Nz = Double.parseDouble(NzField.getText());
            double Iz = Double.parseDouble(IzField.getText());
            double Uz = Double.parseDouble(UzField.getText());
            double I = Double.parseDouble(IField.getText());
            double U = Double.parseDouble(UField.getText());

            double N = Nz * I / Iz * U / Uz;
            DecimalFormat dec = new DecimalFormat("#0.0000");
            NField.setText(dec.format(N));
        } catch(Exception e) {}
    }

    @FXML
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
