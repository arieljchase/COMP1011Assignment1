package com.example.assignment1comp1011;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.List;

public class TableViewScene {
    private Scene scene;
    private Stage stage;

    public TableViewScene(Stage stage, List<SimsGame> simsGames) {
        this.stage = stage;
        VBox root = new VBox();
        root.setPadding(new Insets(10));
        root.setSpacing(10);

        TableView<SimsGame> tableView = new TableView<>();
        ObservableList<SimsGame> data = FXCollections.observableArrayList(simsGames);

        TableColumn<SimsGame, String> nameColumn = new TableColumn<>("Name");
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<SimsGame, Integer> releaseDateColumn = new TableColumn<>("Release Date");
        releaseDateColumn.setCellValueFactory(new PropertyValueFactory<>("releaseDate"));

        TableColumn<SimsGame, String> publisherColumn = new TableColumn<>("Publisher");
        publisherColumn.setCellValueFactory(new PropertyValueFactory<>("publisher"));

        TableColumn<SimsGame, String> developerColumn = new TableColumn<>("Developer");
        developerColumn.setCellValueFactory(new PropertyValueFactory<>("developer"));

        TableColumn<SimsGame, Integer> dlcCountColumn = new TableColumn<>("DLC Count");
        dlcCountColumn.setCellValueFactory(new PropertyValueFactory<>("dlcCount"));

        TableColumn<SimsGame, Integer> worldCountColumn = new TableColumn<>("World Count");
        worldCountColumn.setCellValueFactory(new PropertyValueFactory<>("worldCount"));

        TableColumn<SimsGame, Integer> lifeStagesColumn = new TableColumn<>("Life Stages");
        lifeStagesColumn.setCellValueFactory(new PropertyValueFactory<>("lifeStages"));

        TableColumn<SimsGame, String> gameEngineColumn = new TableColumn<>("Game Engine");
        gameEngineColumn.setCellValueFactory(new PropertyValueFactory<>("gameEngine"));

        TableColumn<SimsGame, Double> totalUnitsSoldColumn = new TableColumn<>("Total Units Sold");
        totalUnitsSoldColumn.setCellValueFactory(new PropertyValueFactory<>("totalUnitsSold"));

        TableColumn<SimsGame, Integer> metacriticScoreColumn = new TableColumn<>("Metacritic Score");
        metacriticScoreColumn.setCellValueFactory(new PropertyValueFactory<>("metacriticScore"));

        tableView.getColumns().addAll(nameColumn, releaseDateColumn, publisherColumn, developerColumn, dlcCountColumn, worldCountColumn, lifeStagesColumn, gameEngineColumn, totalUnitsSoldColumn, metacriticScoreColumn);
        tableView.setItems(data);

        Button switchButton = new Button("Switch to Chart View");
        switchButton.setOnAction(e -> {
            ChartScene chartScene = new ChartScene(stage);
            stage.setScene(chartScene.getScene());
        });

        root.getChildren().addAll(tableView, switchButton);

        scene = new Scene(root, 800, 600);
        scene.getStylesheets().add(getClass().getResource("/styles.css").toExternalForm());
    }

    public Scene getScene() {
        return scene;
    }
}