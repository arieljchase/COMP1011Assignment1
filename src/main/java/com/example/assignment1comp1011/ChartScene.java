package com.example.assignment1comp1011;


import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.Node;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class ChartScene {
    private Scene scene;
    private Stage stage;
    private List<SimsGame> simsGames;
    private int currentChartIndex;
    private VBox root;

    public ChartScene(Stage stage) {
        this.stage = stage;
        this.simsGames = getSimsGames();
        this.currentChartIndex = 0;
        this.root = new VBox();
        root.setPadding(new Insets(10));
        root.setSpacing(10);

        Button cycleChartButton = new Button("Next Chart");
        cycleChartButton.setOnAction(e -> cycleChart());

        Button switchButton = new Button("Show All Data");
        switchButton.setOnAction(e -> {
            TableViewScene tableViewScene = new TableViewScene(stage, simsGames);
            stage.setScene(tableViewScene.getScene());
        });

        root.getChildren().addAll(cycleChartButton, switchButton);
        scene = new Scene(root, 800, 600);
        scene.getStylesheets().add(getClass().getResource("/styles.css").toExternalForm());

        showChart();
    }

    public Scene getScene() {
        return scene;
    }

    private void cycleChart() {
        currentChartIndex = (currentChartIndex + 1) % 3;
        showChart();
    }

    private void showChart() {
        BarChart<String, Number> barChart;
        if (currentChartIndex == 0) {
            barChart = createDlcChart();
        } else if (currentChartIndex == 1) {
            barChart = createMetacriticChart();
        } else {
            barChart = createUnitsSoldChart();
        }

        if (root.getChildren().size() > 2) {
            root.getChildren().remove(2);
        }
        root.getChildren().add(barChart);
    }

    private BarChart<String, Number> createDlcChart() {
        CategoryAxis xAxis = new CategoryAxis();
        NumberAxis yAxis = new NumberAxis();
        BarChart<String, Number> barChart = new BarChart<>(xAxis, yAxis);
        barChart.setTitle("Number of Expansion Packs");
        xAxis.setLabel("Game");
        yAxis.setLabel("DLC Count");

        XYChart.Series<String, Number> series = new XYChart.Series<>();
        series.setName("DLC Count");

        for (SimsGame game : simsGames) {
            XYChart.Data<String, Number> data = new XYChart.Data<>(game.getName(), game.getDlcCount());
            series.getData().add(data);
        }

        barChart.getData().add(series);
        applyStyles(barChart, "DLC Count");
        return barChart;
    }

    private BarChart<String, Number> createMetacriticChart() {
        CategoryAxis xAxis = new CategoryAxis();
        NumberAxis yAxis = new NumberAxis();
        BarChart<String, Number> barChart = new BarChart<>(xAxis, yAxis);
        barChart.setTitle("Metacritic Score");
        xAxis.setLabel("Game");
        yAxis.setLabel("Metacritic Score");

        XYChart.Series<String, Number> series = new XYChart.Series<>();
        series.setName("Metacritic Score");

        for (SimsGame game : simsGames) {
            XYChart.Data<String, Number> data = new XYChart.Data<>(game.getName(), game.getMetacriticScore());
            series.getData().add(data);
        }

        barChart.getData().add(series);
        applyStyles(barChart, "Metacritic Score");
        return barChart;
    }

    private BarChart<String, Number> createUnitsSoldChart() {
        CategoryAxis xAxis = new CategoryAxis();
        NumberAxis yAxis = new NumberAxis();
        BarChart<String, Number> barChart = new BarChart<>(xAxis, yAxis);
        barChart.setTitle("Total Units Sold");
        xAxis.setLabel("Game");
        yAxis.setLabel("Units Sold (Millions)");

        XYChart.Series<String, Number> series = new XYChart.Series<>();
        series.setName("Units Sold");

        for (SimsGame game : simsGames) {
            XYChart.Data<String, Number> data = new XYChart.Data<>(game.getName(), game.getTotalUnitsSold());
            series.getData().add(data);
        }

        barChart.getData().add(series);
        applyStyles(barChart, "Units Sold");
        return barChart;
    }

    private void applyStyles(BarChart<String, Number> barChart, String seriesName) {
        for (XYChart.Series<String, Number> series : barChart.getData()) {
            if (series.getName().equals(seriesName)) {
                for (XYChart.Data<String, Number> data : series.getData()) {
                    Node node = data.getNode();
                    String gameName = data.getXValue();
                    if (gameName.equals("The Sims 1")) {
                        node.setStyle("-fx-bar-fill: #83ccb1;");
                    } else if (gameName.equals("The Sims 2")) {
                        node.setStyle("-fx-bar-fill: #ded18a;");
                    } else if (gameName.equals("The Sims 3")) {
                        node.setStyle("-fx-bar-fill: #64a856;");
                    } else if (gameName.equals("The Sims 4")) {
                        node.setStyle("-fx-bar-fill: #44aafc;");
                    }
                }
            }
        }
    }

    private List<SimsGame> getSimsGames() {
        List<SimsGame> simsGames = new ArrayList<>();
        simsGames.add(new SimsGame("The Sims 1", 2000, "EA", "Maxis", 7, 7, 3, "Sims Engine", 11.5, 92));
        simsGames.add(new SimsGame("The Sims 2", 2004, "EA", "Maxis", 8, 6, 7, "Sims 2 Engine", 6.0, 90));
        simsGames.add(new SimsGame("The Sims 3", 2009, "EA", "The Sims Studio", 11, 18, 7, "Sims 3 Engine", 7.0, 86));
        simsGames.add(new SimsGame("The Sims 4", 2014, "EA", "EA", 12, 25, 8, "Sims 4 Engine", 20.0, 70));
        return simsGames;
    }
}