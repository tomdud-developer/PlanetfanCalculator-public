package com.planetfan.planetfancalculator;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class SimilarityTabController {

    @FXML private TextField Q1_field;
    @FXML private TextField dP1_field;
    @FXML private TextField N1_field;
    @FXML private TextField D1_field;
    @FXML private TextField n1_field;
    @FXML private TextField ro1_field;
    @FXML private TextField Dk_field;
    @FXML private TextField nk_field;
    @FXML private TextField rok_field;
    @FXML private TextField Qk_field;
    @FXML private TextField dPk_field;
    @FXML private TextField Nk_field;
    @FXML private TextField eta_field;
    @FXML private TextField Uk_field;
    @FXML private TextField omega_field;
    @FXML private TextField c_field;
    @FXML private TextField Pd_field;
    @FXML private TextField fi_field;
    @FXML private TextField psi_field;


    @FXML private Button calculateButton;

    Double Q1, dP1, N1, D1, n1, ro1, Dk, nk, rok, Qk, dPk, Nk, eta, U, tot1, tot2, tot3, Pot2, Pot3, fi3, ro, omega, c, Ak, Pd;

    private ArrayList<TextField> inputFieldsList;

    @FXML
    public void initialize(){
        inputFieldsList = new ArrayList<>();
        inputFieldsList.add(Q1_field); inputFieldsList.add(dP1_field); inputFieldsList.add(N1_field);
        inputFieldsList.add(D1_field); inputFieldsList.add(n1_field); inputFieldsList.add(ro1_field);
        inputFieldsList.add(Dk_field); inputFieldsList.add(nk_field); inputFieldsList.add(rok_field);
        inputFieldsList.forEach(n -> n.setText("1"));
        ro1_field.setText("1.293"); rok_field.setText("1.293");
    }

    @FXML
    protected void calculate() {
        if(checkInputs(inputFieldsList)) {
            Q1 = Double.valueOf(Q1_field.getText().replace(',', '.'));
            dP1 = Double.valueOf(dP1_field.getText().replace(',', '.'));
            N1 = Double.valueOf(N1_field.getText().replace(',', '.'));
            D1 = Double.valueOf(D1_field.getText().replace(',', '.'));
            n1 = Double.valueOf(n1_field.getText().replace(',', '.'));
            ro1 = Double.valueOf(ro1_field.getText().replace(',', '.'));

            Dk = Double.valueOf(Dk_field.getText().replace(',', '.'));
            nk = Double.valueOf(nk_field.getText().replace(',', '.'));
            rok = Double.valueOf(rok_field.getText().replace(',', '.'));

            Qk = Q1 * nk / n1 * Math.pow(Dk/D1, 3);
            dPk = dP1 * rok / ro1 * Math.pow(Dk/D1, 2) * Math.pow(nk/n1, 2);
            Nk = rok / ro1 * Math.pow(Dk/D1, 5) * Math.pow(nk/n1, 3) * N1;
            eta = Q1 * dP1 / N1 * 100 / 1000;
            U = Math.PI * Dk * nk / 60;
            omega = 2 * Math.PI * nk / 60;
            Ak = Math.PI * Math.pow(Dk, 2) / 4;
            c = Qk / Ak;
            Pd = rok * Math.pow(c, 2) / 2;

            double fi = Q1 / (Math.PI / 4 * Math.pow(D1, 2) * (Math.PI * D1 * n1 / 60));
            double psi = dP1 / (0.5 * ro1 * Math.pow(Math.PI * D1 * n1 / 60, 2));

            DecimalFormat dec = new DecimalFormat("#0.0000");
            DecimalFormat decEta = new DecimalFormat("#0");

            Qk_field.setText(dec.format(Qk));
            dPk_field.setText(dec.format(dPk));
            Nk_field.setText(dec.format(Nk));
            eta_field.setText(decEta.format(eta));
            Uk_field.setText(dec.format(U));
            omega_field.setText(dec.format(omega));
            c_field.setText(dec.format(c));
            Pd_field.setText(dec.format(Pd));
            fi_field.setText(dec.format(fi));
            psi_field.setText(dec.format(psi));
        }
    }

    private boolean checkInputs(ArrayList<TextField> input) {
        for(TextField t : input)
            if(t.getText().isEmpty())
                return false;

        return true;
    }


}
