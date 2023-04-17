package com.planetfan.planetfancalculator.measure.rectangle;

import com.planetfan.planetfancalculator.measure.circle.Pressure;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
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

public class MeasurePrantelRectangleTabController implements Initializable {

    public static TableView<Data> table_info_app;
    public static ObservableList<Data> data_table;

    private final int rows = 6;
    private final int cols = 6;

    @FXML private TableView<Data> table_info;
    @FXML private TableColumn<Data, Double> col1, col2, col3, col4, col5, col6;
    @FXML private TableColumn<Data, Integer> column_id;


    @FXML TextField averageDataField;

    @FXML TextField lenHeightFromWall;
    @FXML TextField lenHeight;
    @FXML TextField lenWidthFromWall;
    @FXML TextField lenWidth;



    @FXML TextField heightField;
    @FXML TextField widthField;
    @FXML TextField areaField;
    @FXML TextField velocityField;
    @FXML TextField efficiencyField;


    @FXML
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        table_info_app=table_info;
        initializeCols();
        loadDefaultData();
        editableCols();
        heightField.setText("1.050");
        widthField.setText("0.500");
        calculateAvg();
        widthAndHeightTyped();
        calculateVelocityEfficiency();
    }

    private void initializeCols(){
        column_id.setCellValueFactory(new PropertyValueFactory<>("id"));
        col1.setCellValueFactory(new PropertyValueFactory<>("col1"));
        col2.setCellValueFactory(new PropertyValueFactory<>("col2"));
        col3.setCellValueFactory(new PropertyValueFactory<>("col3"));
        col4.setCellValueFactory(new PropertyValueFactory<>("col4"));
        col5.setCellValueFactory(new PropertyValueFactory<>("col5"));
        col6.setCellValueFactory(new PropertyValueFactory<>("col6"));
    }

    private void loadDefaultData(){
        data_table= FXCollections.observableArrayList();
        for(int x=1; x <= rows; x++){
            data_table.add(new Data(x, 10,10,10,10,10,10));
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

        col1.setCellFactory(TextFieldTableCell.forTableColumn(stringDoubleConverter));
        col2.setCellFactory(TextFieldTableCell.forTableColumn(stringDoubleConverter));
        col3.setCellFactory(TextFieldTableCell.forTableColumn(stringDoubleConverter));
        col4.setCellFactory(TextFieldTableCell.forTableColumn(stringDoubleConverter));
        col5.setCellFactory(TextFieldTableCell.forTableColumn(stringDoubleConverter));
        col6.setCellFactory(TextFieldTableCell.forTableColumn(stringDoubleConverter));

        col1.setOnEditCommit(e -> {
            e.getTableView().getItems().get(e.getTablePosition().getRow()).setCol1(e.getNewValue());
            calculateAvg();
            calculateVelocityEfficiency();
        });
        col2.setOnEditCommit(e -> {
            e.getTableView().getItems().get(e.getTablePosition().getRow()).setCol1(e.getNewValue());
            calculateAvg();
            calculateVelocityEfficiency();
        });
        col3.setOnEditCommit(e -> {
            e.getTableView().getItems().get(e.getTablePosition().getRow()).setCol1(e.getNewValue());
            calculateAvg();
            calculateVelocityEfficiency();
        });
        col4.setOnEditCommit(e -> {
            e.getTableView().getItems().get(e.getTablePosition().getRow()).setCol1(e.getNewValue());
            calculateAvg();
            calculateVelocityEfficiency();
        });
        col5.setOnEditCommit(e -> {
            e.getTableView().getItems().get(e.getTablePosition().getRow()).setCol1(e.getNewValue());
            calculateAvg();
            calculateVelocityEfficiency();
        });
        col6.setOnEditCommit(e -> {
            e.getTableView().getItems().get(e.getTablePosition().getRow()).setCol1(e.getNewValue());
            calculateAvg();
            calculateVelocityEfficiency();
        });

        table_info.setEditable(true);
    }

    private void calculateAvg() {
        DecimalFormat dec = new DecimalFormat("#0.00");
        averageDataField.setText(dec.format(getAvg()));
        calculateVelocityEfficiency();
    }

    @FXML
    protected void widthAndHeightTyped() {
        double width = Double.parseDouble(widthField.getText());
        double height = Double.parseDouble(heightField.getText());
        double area = width * height;
        DecimalFormat dec = new DecimalFormat("#0.000");
        areaField.setText(dec.format(area));

        lenWidthFromWall.setText(dec.format(width / 6));
        lenWidth.setText(dec.format(width / 12));
        lenHeightFromWall.setText(dec.format(height / 12));
        lenHeight.setText(dec.format(height / 6));

        calculateVelocityEfficiency();
    }

    protected double getAvg() {
        double sum = 0;
        for(Data pr : table_info.getItems())
            sum += pr.getSum();
        return sum/rows/cols;
    }
    protected void calculateVelocityEfficiency() {
        double width = Double.parseDouble(widthField.getText());
        double height = Double.parseDouble(heightField.getText());
        double area = width * height;
        double avg = getAvg();
        double velocity = Math.sqrt(0.6 * avg);
        double efficiency = area * velocity;

        DecimalFormat dec = new DecimalFormat("#0.00");
        velocityField.setText(dec.format(velocity));
        efficiencyField.setText(dec.format(efficiency));
    }


}
