package br.com.inspection.domain;

import javax.json.bind.annotation.JsonbProperty;

public class InspectionResult {

    @JsonbProperty("biggest_spot_area")
    private int biggestSpotArea;
    @JsonbProperty("number_of_spots")
    private int numberOfSpots;
    @JsonbProperty("total_area")
    private int totalArea;
    @JsonbProperty("spots_average_area")
    private double averageSpotArea;

    public void calculateAverageSpotArea() {
        if (this.numberOfSpots != 0) {
            this.averageSpotArea = (double)this.totalArea / (double)this.numberOfSpots;
        }
    }

    public int getBiggestSpotArea() {
        return biggestSpotArea;
    }

    public void setBiggestSpotArea(int biggestSpotArea) {
        this.biggestSpotArea = biggestSpotArea;
    }

    public int getNumberOfSpots() {
        return numberOfSpots;
    }

    public void setNumberOfSpots(int numberOfSpots) {
        this.numberOfSpots = numberOfSpots;
    }

    public void setTotalArea(int totalArea) {
        this.totalArea = totalArea;
    }

    public Integer getTotalArea() {
        return totalArea;
    }

    public double getAverageSpotArea() {
        return averageSpotArea;
    }

    public void setAverageSpotArea(double averageSpotArea) {
        this.averageSpotArea = averageSpotArea;
    }
}
