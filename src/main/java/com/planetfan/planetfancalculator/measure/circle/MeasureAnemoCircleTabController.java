package com.planetfan.planetfancalculator.measure.circle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.StringConverter;

import java.net.URL;
import java.text.DecimalFormat;
import java.util.ResourceBundle;

public class MeasureAnemoCircleTabController implements Initializable {

    public static TableView<Velocity> table_info_app;
    public static ObservableList<Velocity> data_table;

    private final int rows = 8;

    @FXML private TableView<Velocity> table_info;
    @FXML private TableColumn<Velocity, Double> column_velocity, column_len;
    @FXML private TableColumn<Velocity, Integer> column_id;
    @FXML private TableColumn<Velocity, String> column_velocityUnit, column_lenUnit;

    @FXML TextField averageVelocityField;
    @FXML TextField diameterField;
    @FXML TextField areaField;
    @FXML TextField efficiencyField;


    @FXML
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        table_info_app = table_info;
        initializeCols();
        loadDefaultData();
        editableCols();
        diameterField.setText("0.8");
        calculateAvg();
        diameterTyped();
        calculateVelocityEfficiency();
        depthFill();
    }

    private void initializeCols(){
        column_id.setCellValueFactory(new PropertyValueFactory<>("id"));
        column_velocity.setCellValueFactory(new PropertyValueFactory<>("velocity"));
        column_velocityUnit.setCellValueFactory(new PropertyValueFactory<>("velocityUnit"));
        column_len.setCellValueFactory(new PropertyValueFactory<>("len"));
        column_lenUnit.setCellValueFactory(new PropertyValueFactory<>("lenUnit"));
    }

    private void loadDefaultData(){
        data_table= FXCollections.observableArrayList();
        for(int x=1; x <= rows; x++){
            data_table.add(new Velocity(x, 2.4, "[m/s]", x * 10.0 ,  "[mm]"));
        }
        table_info.setItems(data_table);
    }

    private void editableCols(){
        StringConverter<Integer> stringIntegerConverter = new StringConverter<Integer>() {
            @Override
            public String toString(Integer integer) {
                return String.valueOf(integer);
            }
            @Override
            public Integer fromString(String s) {
                return Integer.valueOf(s);
            }
        };
        StringConverter<Double> stringDoubleConverter = new StringConverter<Double>() {
            @Override
            public String toString(Double doub) {
                return String.valueOf(doub);
            }
            @Override
            public Double fromString(String s) {
                return Double.valueOf(s);
            }
        };

        column_velocity.setCellFactory(TextFieldTableCell.forTableColumn(stringDoubleConverter));
        column_velocity.setOnEditCommit(e -> {
            e.getTableView().getItems().get(e.getTablePosition().getRow()).setVelocity(e.getNewValue());
            calculateAvg();
            calculateVelocityEfficiency();
        });

        column_len.setCellFactory(TextFieldTableCell.forTableColumn(stringDoubleConverter));
        column_len.setOnEditCommit(e-> {
            e.getTableView().getItems().get(e.getTablePosition().getRow()).setLen(e.getNewValue());
            calculateVelocityEfficiency();
        });

        table_info.setEditable(true);
    }

    private void calculateAvg() {
        DecimalFormat dec = new DecimalFormat("#0.00");
        averageVelocityField.setText(dec.format(getAvg()));
        calculateVelocityEfficiency();
    }

    @FXML
    private void depthFill() {
        for(Velocity pr : table_info.getItems()) {
            double dia = Double.parseDouble(diameterField.getText());
            double multiplicationIndex = 0;
            switch(pr.id) {
                case 1: multiplicationIndex = 0.25; break;
                case 2: multiplicationIndex = 0.43; break;
                case 3: multiplicationIndex = 0.56; break;
                case 4: multiplicationIndex = 0.66; break;
                case 5: multiplicationIndex = 0.75; break;
                case 6: multiplicationIndex = 0.829; break;
                case 7: multiplicationIndex = 0.901; break;
                case 8: multiplicationIndex = 0.968; break;
            }
            double l = (dia / 2 - multiplicationIndex * dia/2 ) * 1000;
            pr.setLen((double)Math.round(l));
            table_info.refresh();
        }
    }

    @FXML
    protected void diameterTyped() {
        double dia = Double.parseDouble(diameterField.getText());
        double area = Math.PI * Math.pow(dia, 2) / 4;
        DecimalFormat dec = new DecimalFormat("#0.00");
        areaField.setText(dec.format(area));
        calculateVelocityEfficiency();
    }

    protected double getAvg() {
        double sum = 0;
        for(Velocity pr : table_info.getItems())
            sum += pr.getVelocity();
        return sum/rows;
    }
    protected void calculateVelocityEfficiency() {
        double dia = Double.parseDouble(diameterField.getText());
        double area = Math.PI * Math.pow(dia, 2) / 4;
        double avg = getAvg();
        double efficiency = area * avg;

        DecimalFormat dec = new DecimalFormat("#0.00");
        efficiencyField.setText(dec.format(efficiency));
    }


}
