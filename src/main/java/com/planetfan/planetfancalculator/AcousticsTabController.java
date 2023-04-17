package com.planetfan.planetfancalculator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.ResourceBundle;

public class AcousticsTabController {

    @FXML private Button A_1_infoButton;
    @FXML private TextField A_1_LAeq_field;
    @FXML private TextField A_1_d_field;
    @FXML private TextField A_1_r_field;
    @FXML private TextField A_1_PWL_field;
    @FXML private TextField A_2_PWL_field;
    @FXML private TextField A_2_x_field;
    @FXML private TextField A_2_LAeq_field;
    @FXML private TextField A_3_LAeq1_field;
    @FXML private TextField A_3_z1_field;
    @FXML private TextField A_3_z2_field;
    @FXML private TextField A_3_LAeq_field;
    @FXML private TextField A_4_PWL1_field;
    @FXML private TextField A_4_n1_field;
    @FXML private TextField A_4_n2_field;
    @FXML private TextField A_4_PWL_field;
    @FXML private TextField A_5_PWL1_field;
    @FXML private TextField A_5_D1_field;
    @FXML private TextField A_5_D2_field;
    @FXML private TextField A_5_PWL_field;

    @FXML private TextField A_ZCAWZOZL_LAeq1_field;
    @FXML private TextField A_ZCAWZOZL_z1_field;
    @FXML private TextField A_ZCAWZOZL_z2_field;
    @FXML private TextField A_ZCAWZOZL_LAeq_field;

    @FXML private TextField A_KMLCWZOIZ_PWL_field;
    @FXML private TextField A_KMLCWZOIZ_i_field;
    @FXML private TextField A_KMLCWZOIZ_PWL2_field;

    @FXML private TextField A_PO_v_field;
    @FXML private TextField A_PO_D_field;
    @FXML private TextField A_PO_n_field;

    @FXML private TextField A_OOZ_D_field;
    @FXML private TextField A_OOZ_R_field;
    @FXML private TextField A_OOZ_Z_field;
    @FXML private TextField A_OOZ_Area_field;
    @FXML private TextField A_OOZ_Perimeter_field;
    @FXML private TextField A_OOZ_Sphere1_field;
    @FXML private TextField A_OOZ_Sphere2_field;



    Double A_1_LAeq, A_1_d, A_1_r, A_1_PWL, A_2_PWL, A_2_x, A_2_LAeq, A_3_LAeq1,A_3_z1, A_3_z2, A_3_LAeq, A_4_PWL1, A_4_n1, A_4_n2, A_4_PWL, A_5_PWL1,A_5_D1, A_5_D2, A_5_PWL;



    @FXML
    protected void initialize() {
        //A_1_infoButton.setText("clicked");
        //A_1_infoButton.setGraphic(new ImageView(Application.class.getResource("acousticPower_helpPane.fxml").getPath()));

    }

    @FXML
    protected void A_1_calculateClick(){
        A_1_LAeq = Double.valueOf(A_1_LAeq_field.getText().replace(',', '.'));
        A_1_d = Double.valueOf(A_1_d_field.getText().replace(',', '.'));
        A_1_r = Double.valueOf(A_1_r_field.getText().replace(',', '.'));
        A_1_PWL = A_1_LAeq + 10 * Math.log10(2 * Math.PI * Math.pow(A_1_r + 0.5 * A_1_d, 2));



        DecimalFormat dec = new DecimalFormat("#0.0000");

        A_1_PWL_field.setText(dec.format(A_1_PWL));
    }

    //Halas w punkcie
    @FXML
    protected void A_2_calculateClick(){
        A_2_PWL = Double.valueOf(A_2_PWL_field.getText().replace(',', '.'));
        A_2_x = Double.valueOf(A_2_x_field.getText().replace(',', '.'));
        A_2_LAeq = A_2_PWL - 10  * Math.log10(2 * Math.PI * Math.pow(A_2_x, 2));

        DecimalFormat dec = new DecimalFormat("#0.0000");

        A_2_LAeq_field.setText(dec.format(A_2_LAeq));
    }

    @FXML
    protected void A_3_calculateClick(){
        A_3_LAeq1 = Double.valueOf(A_3_LAeq1_field.getText().replace(',', '.'));
        A_3_z1 = Double.valueOf(A_3_z1_field.getText().replace(',', '.'));
        A_3_z2 = Double.valueOf(A_3_z2_field.getText().replace(',', '.'));

        A_3_LAeq = A_3_LAeq1 - 20  * Math.log10(A_3_z2 / A_3_z1);

        DecimalFormat dec = new DecimalFormat("#0.0000");

        A_3_LAeq_field.setText(dec.format(A_3_LAeq));
    }


    //korekta mocy akustycznej w zaleznosci od obrotow
    @FXML
    protected void A_4_calculateClick(){
        A_4_PWL1 = Double.valueOf(A_4_PWL1_field.getText().replace(',', '.'));
        A_4_n1 = Double.valueOf(A_4_n1_field.getText().replace(',', '.'));
        A_4_n2 = Double.valueOf(A_4_n2_field.getText().replace(',', '.'));

        A_4_PWL = A_4_PWL1 + 50  * Math.log10(A_4_n2 / A_4_n1);

        DecimalFormat dec = new DecimalFormat("#0.0000");

        A_4_PWL_field.setText(dec.format(A_4_PWL));
    }

    @FXML
    protected void A_5_calculateClick(){
        A_5_PWL1 = Double.valueOf(A_5_PWL1_field.getText().replace(',', '.'));
        A_5_D1 = Double.valueOf(A_5_D1_field.getText().replace(',', '.'));
        A_5_D2 = Double.valueOf(A_5_D2_field.getText().replace(',', '.'));

        A_5_PWL = A_5_PWL1 + 70  * Math.log10(A_5_D2 / A_5_D1);

        DecimalFormat dec = new DecimalFormat("#0.0000");

        A_5_PWL_field.setText(dec.format(A_5_PWL));
    }


    //Zmiana ciśnienia akustycznego wraz z odległościa - żródło liniowe
    @FXML
    protected void A_ZCAWZOZL_calculateClick(){
        double LAeq1 = Double.parseDouble(A_ZCAWZOZL_LAeq1_field.getText().replace(',', '.'));
        double z1 = Double.parseDouble(A_ZCAWZOZL_z1_field.getText().replace(',', '.'));
        double z2 = Double.parseDouble(A_ZCAWZOZL_z2_field.getText().replace(',', '.'));

        double LAeq = LAeq1 - 10  * Math.log10(z2 / z1);

        DecimalFormat dec = new DecimalFormat("#0.0000");

        A_ZCAWZOZL_LAeq_field.setText(dec.format(LAeq));
    }

    @FXML
    protected void A_KMLCWZOIZ_calculateClick() {
        double PWL = Double.parseDouble(A_KMLCWZOIZ_PWL_field.getText().replace(',', '.'));
        double i = Double.parseDouble(A_KMLCWZOIZ_i_field.getText().replace(',', '.'));
        double PWL2 = PWL + 10 * Math.log10(i);
        DecimalFormat dec = new DecimalFormat("#0.0000");
        A_KMLCWZOIZ_PWL2_field.setText(dec.format(PWL2));
    }

    @FXML
    protected void A_PO_calculateClick() {
        double D = Double.parseDouble(A_PO_D_field.getText().replace(',', '.'));
        double n = Double.parseDouble(A_PO_n_field.getText().replace(',', '.'));
        double v = Math.PI * D * n/60;
        DecimalFormat dec = new DecimalFormat("#0.0000");
        A_PO_v_field.setText(dec.format(v));
    }

    @FXML
    protected void A_OZZ_R_typed() {
        if(A_OOZ_R_field.getText().isEmpty()) {
            A_OOZ_Area_field.setText("");
            A_OOZ_Perimeter_field.setText("");
            A_OOZ_Sphere1_field.setText("");
        } else {
            A_OZZ_Area_calc();
            A_OZZ_Perimeter_calc();
            A_OZZ_Sphere1_calc();
        }
    }

    @FXML
    protected void A_OZZ_DZ_typed() {
        if(A_OOZ_D_field.getText().isEmpty() || A_OOZ_Z_field.getText().isEmpty()) {
            A_OOZ_Sphere2_field.setText("");
        }
        else
            A_OZZ_Sphere2_calc();
    }

    protected void A_OZZ_Area_calc() {
        double R = Double.parseDouble(A_OOZ_R_field.getText().replace(',', '.'));
        double A = Math.PI * Math.pow(R, 2) / 2;
        DecimalFormat dec = new DecimalFormat("#0.0000");
        A_OOZ_Area_field.setText(dec.format(A));
    }

    protected void A_OZZ_Perimeter_calc() {
        double R = Double.parseDouble(A_OOZ_R_field.getText().replace(',', '.'));
        double l = Math.PI  * R;
        DecimalFormat dec = new DecimalFormat("#0.0000");
        A_OOZ_Perimeter_field.setText(dec.format(l));
    }

    protected void A_OZZ_Sphere1_calc() {
        double R = Double.parseDouble(A_OOZ_R_field.getText().replace(',', '.'));
        double A = 4 * Math.PI * Math.pow(R, 2) / 2;
        DecimalFormat dec = new DecimalFormat("#0.0000");
        A_OOZ_Sphere1_field.setText(dec.format(A));
    }

    protected void A_OZZ_Sphere2_calc() {
        double D = Double.parseDouble(A_OOZ_D_field.getText().replace(',', '.'));
        double Z = Double.parseDouble(A_OOZ_Z_field.getText().replace(',', '.'));
        double R = Z + D/2;
        double A = 4 * Math.PI * Math.pow(R, 2) / 2;
        DecimalFormat dec = new DecimalFormat("#0.0000");
        A_OOZ_Sphere2_field.setText(dec.format(A));
    }

    @FXML
    protected void A_1_infoButtonClick(ActionEvent event) {
        Parent root;
        try {
            root = FXMLLoader.load(Application.class.getResource("acousticPower_helpPane.fxml"));
            Stage stage = new Stage();
            Scene scene = new Scene(root, 450, 450);
            String css = Application.class.getResource("styles.css").toExternalForm();
            scene.getStylesheets().add(css);
            stage.getIcons().add(new Image(Application.class.getResourceAsStream("logo.png")));
            stage.setTitle("Rysunek pomocniczy - moc akustyczna");
            stage.setScene(scene);
            stage.show();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }


}
