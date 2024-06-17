package com.example.assignment1comp1011;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        ChartScene chartScene = new ChartScene(primaryStage);
        primaryStage.setTitle("Comparing The Sims Franchise");
        primaryStage.setScene(chartScene.getScene());
        Image icon = new Image(getClass().getResourceAsStream("/plumbob.png"));
        primaryStage.getIcons().add(icon);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}