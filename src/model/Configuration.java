package model;

public class Configuration {
    private final Resolution resolution;
    private double complexity;


    public double getComplexity() {
        return complexity;
    }

    public Resolution getResolution() {
        return resolution;
    }

    public Configuration(Resolution resolution) {
        this.resolution = resolution;
    }

    public Configuration(Resolution resolution, double complexity) {
        this.resolution = resolution;
        this.complexity = complexity;
    }
}
