package com.planetfan.planetfancalculator;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TabPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

import java.io.IOException;

public class Application extends javafx.application.Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("mainView.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        System.out.println();
        String css = Application.class.getResource("styles.css").toExternalForm();
        scene.getStylesheets().add(css);
        stage.getIcons().add(new Image(Application.class.getResourceAsStream("logo.png")));
        stage.setTitle("PlanetFan Calculator");
        stage.setScene(scene);
        stage.show();
        TabPane tp = (TabPane) scene.lookup("#tabPane");
        //tp.getTabs().get(0).setGraphic(new ImageView(new Image(Application.class.getResourceAsStream("similarityIcon.png"))));
    }

    public static void main(String[] args) {
        launch();
    }
}