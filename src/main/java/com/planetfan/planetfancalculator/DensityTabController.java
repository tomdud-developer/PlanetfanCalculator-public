package com.planetfan.planetfancalculator;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.text.DecimalFormat;

public class DensityTabController {

    @FXML private TextField tot1_field;
    @FXML private TextField tot2_field;
    @FXML private TextField Pot2_field;
    @FXML private TextField tot3_field;
    @FXML private TextField Pot3_field;
    @FXML private TextField fi3_field;
    @FXML private TextField ro_field;
    @FXML private Button calculate1Button;
    @FXML private Button calculate2Button;
    @FXML private Button calculate3Button;
    @FXML private Label methodLabel;


    Double Q1, dP1, N1, D1, n1, ro1, Dk, nk, rok, Qk, dPk, Nk, eta, U, tot1, tot2, tot3, Pot2, Pot3, fi3, ro, omega, c, Ak, Pd;

    @FXML
    public void initialize(){
        tot1_field.setText("24"); tot2_field.setText("24"); tot3_field.setText("24");
        Pot2_field.setText("101325"); Pot3_field.setText("101325");
        fi3_field.setText("40");
    }

    @FXML
    protected void calculate1(){
        if(!tot1_field.getText().isEmpty()){
            tot1 = Double.valueOf(tot1_field.getText().replace(',', '.'));
            ro = 1.2 * 293.15 / (tot1 + 273.15);

            DecimalFormat dec = new DecimalFormat("#0.00000");
            ro_field.setText(dec.format(ro));
            methodLabel.setText("Obliczono metodą 1.");
        }
    }
    @FXML
    protected void calculate2(){
        if(!tot2_field.getText().isEmpty() && !Pot2_field.getText().isEmpty()){
            tot2 = Double.valueOf(tot2_field.getText().replace(',', '.'));
            Pot2 = Double.valueOf(Pot2_field.getText().replace(',', '.'));
            ro = 1.2 * 293.15 / (tot2 + 273.15) * (Pot2 / 101325);
            DecimalFormat dec = new DecimalFormat("#0.00000");
            ro_field.setText(dec.format(ro));
            methodLabel.setText("Obliczono metodą 2.");
        }
    }
    @FXML
    protected void calculate3(){
        if(!tot3_field.getText().isEmpty() && !Pot3_field.getText().isEmpty() && !fi3_field.getText().isEmpty()){
            tot3 = Double.valueOf(tot3_field.getText().replace(',', '.'));
            Pot3 = Double.valueOf(Pot3_field.getText().replace(',', '.'));
            fi3 = Double.valueOf(fi3_field.getText().replace(',', '.'));
            fi3 = fi3 / 100; // From percentage

/*
            double R, Rp;
            Rp = 613.23918 * Math.exp(0.07147 * tot3 - 0.0002335 * Math.pow(tot3, 2));
            R = 297.04 / ( (1 - 0.00378 * fi3 * Rp) / (Pot3 * 100) );
            ro = Pot3 * 100 / R / (tot3 + 273.15);
*/
            ro = 1 / ( 287.06 * (tot3 + 273.15) ) * ( Pot3 - 230.617 * fi3 * Math.exp( 17.5043 * tot3/(241.2+tot3))  );

            DecimalFormat dec = new DecimalFormat("#0.00000");
            ro_field.setText(dec.format(ro));
            methodLabel.setText("Obliczono metodą 3.");
        }
    }

}
