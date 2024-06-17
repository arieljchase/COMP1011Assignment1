package com.example.assignment1comp1011;

public class SimsGame {
    private String name;
    private int releaseDate;
    private String publisher;
    private String developer;
    private int dlcCount;
    private int worldCount;
    private int lifeStages;
    private String gameEngine;
    private double totalUnitsSold;
    private int metacriticScore;

    public SimsGame(String name, int releaseDate, String publisher, String developer, int dlcCount, int worldCount, int lifeStages, String gameEngine, double totalUnitsSold, int metacriticScore) {
        this.name = name;
        this.releaseDate = releaseDate;
        this.publisher = publisher;
        this.developer = developer;
        this.dlcCount = dlcCount;
        this.worldCount = worldCount;
        this.lifeStages = lifeStages;
        this.gameEngine = gameEngine;
        this.totalUnitsSold = totalUnitsSold;
        this.metacriticScore = metacriticScore;
    }

    // Getters and setters
    public String getName() { return name; }
    public int getReleaseDate() { return releaseDate; }
    public String getPublisher() { return publisher; }
    public String getDeveloper() { return developer; }
    public int getDlcCount() { return dlcCount; }
    public int getWorldCount() { return worldCount; }
    public int getLifeStages() { return lifeStages; }
    public String getGameEngine() { return gameEngine; }
    public double getTotalUnitsSold() { return totalUnitsSold; }
    public int getMetacriticScore() { return metacriticScore; }
}