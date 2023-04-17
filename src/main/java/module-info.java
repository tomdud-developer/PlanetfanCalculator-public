module com.planetfan.planetfancalculator.calculator {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.planetfan.planetfancalculator to javafx.fxml;
    exports com.planetfan.planetfancalculator;

    exports com.planetfan.planetfancalculator.measure.circle;
    opens com.planetfan.planetfancalculator.measure.circle to javafx.fxml;
    exports com.planetfan.planetfancalculator.measure.rectangle;
    opens com.planetfan.planetfancalculator.measure.rectangle to javafx.fxml;
    exports com.planetfan.planetfancalculator.measure.power;
    opens com.planetfan.planetfancalculator.measure.power to javafx.fxml;
}