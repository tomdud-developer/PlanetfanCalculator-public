package com.planetfan.planetfancalculator;


import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

import java.net.URL;
import java.text.DecimalFormat;
import java.util.ResourceBundle;
import com.planetfan.planetfancalculator.calculators.Mass;
public class MassTabController implements Initializable{

    @FXML CheckBox editDensityCheckBox;
    @FXML TextField aluDensityField;
    @FXML TextField stellDensityField;
    @FXML ChoiceBox<String> materialChoiceBox;

    @FXML TextField sheetField_S;
    @FXML TextField sheetField_D;
    @FXML TextField sheetField_H;
    @FXML TextField sheetField_mass;

    @FXML TextField rodField_S;
    @FXML TextField rodField_D;
    @FXML TextField rodField_mass;

    @FXML TextField tubeField_S;
    @FXML TextField tubeField_D;
    @FXML TextField tubeField_C;
    @FXML TextField tubeField_mass;

    @FXML TextField squareProfileField_HS;
    @FXML TextField squareProfileField_D;
    @FXML TextField squareProfileField_C;
    @FXML TextField squareProfileField_mass;

    @FXML TextField rectProfileField_H;
    @FXML TextField rectProfileField_S;
    @FXML TextField rectProfileField_D;
    @FXML TextField rectProfileField_C;
    @FXML TextField rectProfileField_mass;

    @FXML TextField angleField_H;
    @FXML TextField angleField_S;
    @FXML TextField angleField_D;
    @FXML TextField angleField_C;
    @FXML TextField angleField_mass;

    @FXML TextField teeField_H;
    @FXML TextField teeField_S;
    @FXML TextField teeField_D;
    @FXML TextField teeField_C;
    @FXML TextField teeField_mass;


    private double currentDensisty = 0.0;
    private String material;
    private final DecimalFormat dec = new DecimalFormat("#0.000");



    @FXML
    @Override
    public void initialize(URL url,ResourceBundle resourceBundle) {
        aluDensityField.setText("2700");
        stellDensityField.setText("7850");
        aluDensityField.setEditable(false);
        stellDensityField.setEditable(false);
        editDensityCheckBox.setSelected(false);
        stellDensityField.setEditable(false);
        aluDensityField.setDisable(true);
        stellDensityField.setDisable(true);
        materialChoiceBox.setItems(FXCollections.observableArrayList(
                "Stal", "Aluminium")
        );
        materialChoiceBox.setValue("Stal");
        material = "Stal";
        materialChoiceCheckAddListener();
        currentDensisty = Double.parseDouble(stellDensityField.getText());
    }

    @FXML
    protected void clickDensityCheckBox() {
        if(editDensityCheckBox.isSelected()) {
            aluDensityField.setEditable(true);
            stellDensityField.setEditable(true);
            aluDensityField.setDisable(false);
            stellDensityField.setDisable(false);
        } else {
            aluDensityField.setEditable(false);
            stellDensityField.setEditable(false);
            aluDensityField.setDisable(true);
            stellDensityField.setDisable(true);
        }
        calculate();
    }

    private void materialChoiceCheckAddListener() {
        materialChoiceBox.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                if(t1.intValue() == 0) {
                    material = "Stal";
                }
                else if(t1.intValue() == 1) {
                    material = "Aluminium";
                }
                materialDensityUpdate();
                calculate();
            }
        });
    }

    @FXML
    private void materialDensityUpdate() {
        if(material.equals("Stal")) {
            currentDensisty = Double.parseDouble(stellDensityField.getText());
        }
        else if(material.equals("Aluminium")) {
            currentDensisty = Double.parseDouble(aluDensityField.getText());
        }
    }

    private void calculateSheet() {
        try {
            double S = Double.parseDouble(sheetField_S.getText());
            double D = Double.parseDouble(sheetField_D.getText());
            double H = Double.parseDouble(sheetField_H.getText());
            double mass = Mass.sheet(S, D, H, this.currentDensisty);
            sheetField_mass.setText(String.valueOf(dec.format(mass)));
        } catch (Exception e) {
        }
    }

    private void calculateRod() {
        try {
            double S = Double.parseDouble(rodField_S.getText());
            double D = Double.parseDouble(rodField_D.getText());
            double mass = Mass.rod(S, D, this.currentDensisty);
            rodField_mass.setText(String.valueOf(dec.format(mass)));
        } catch (Exception e) {
        }
    }

    private void calculateTube() {
        try {
            double S = Double.parseDouble(tubeField_S.getText());
            double D = Double.parseDouble(tubeField_D.getText());
            double C = Double.parseDouble(tubeField_C.getText());
            double mass = Mass.tube(S, C, D, this.currentDensisty);
            tubeField_mass.setText(String.valueOf(dec.format(mass)));
        } catch (Exception e) {
        }
    }

    private void calculateSquareProfile() {
        try {
            double HS = Double.parseDouble(squareProfileField_HS.getText());
            double D = Double.parseDouble(squareProfileField_D.getText());
            double C = Double.parseDouble(squareProfileField_C.getText());
            double mass = Mass.squareProfile(HS, D, C, this.currentDensisty);
            squareProfileField_mass.setText(String.valueOf(dec.format(mass)));
        } catch (Exception e) {
        }
    }

    private void calculateRectProfile() {
        try {
            double H = Double.parseDouble(rectProfileField_H.getText());
            double S = Double.parseDouble(rectProfileField_S.getText());
            double D = Double.parseDouble(rectProfileField_D.getText());
            double C = Double.parseDouble(rectProfileField_C.getText());
            double mass = Mass.rectangleProfile(H, S, D, C, this.currentDensisty);
            rectProfileField_mass.setText(String.valueOf(dec.format(mass)));
        } catch (Exception e) {
        }
    }

    private void calculateAngle() {
        try {
            double H = Double.parseDouble(angleField_H.getText());
            double S = Double.parseDouble(angleField_S.getText());
            double D = Double.parseDouble(angleField_D.getText());
            double C = Double.parseDouble(angleField_C.getText());
            double mass = Mass.angleProfile(H, S, C, D, this.currentDensisty);
            angleField_mass.setText(String.valueOf(dec.format(mass)));
        } catch (Exception e) {
        }
    }

    private void calculateTee() {
        try {
            double H = Double.parseDouble(teeField_H.getText());
            double S = Double.parseDouble(teeField_S.getText());
            double D = Double.parseDouble(teeField_D.getText());
            double C = Double.parseDouble(teeField_C.getText());
            double mass = Mass.tee(H, S, C, D, this.currentDensisty);
            teeField_mass.setText(String.valueOf(dec.format(mass)));
        } catch (Exception e) {
        }
    }

    @FXML
    protected void calculate() {
        materialDensityUpdate();
        calculateSheet();
        calculateRod();
        calculateTube();
        calculateSquareProfile();
        calculateRectProfile();
        calculateAngle();
        calculateTee();
    }
}
