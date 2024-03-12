package edu.iu.habahram.weathermonitoring.model;

public class StatisticsDisplay implements Observer, DisplayElement {
    private float maxTemp = 78.0f;
    private float minTemp = 50.0f;

    private float AvgTemp = 62.0f;
    private float tempSum = 0.0f;
    private int numReadings;
    private WeatherData weatherData;

    public StatisticsDisplay(WeatherData weatherData) {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    public void update(float temp, float humidity, float pressure) {
        tempSum += temp;
        numReadings++;

        if (temp > maxTemp) {
            maxTemp = temp;
        }

        if (temp < minTemp) {
            minTemp = temp;
        }

        display();
    }

    @Override
    public String name() {
        return null;
    }

    @Override
    public String id() {
        return null;
    }

    public String display() {

        String statistics = "Avg/Max/Min temperature = " + (tempSum / numReadings)
                + "/" + maxTemp + "/" + minTemp;
        System.out.println(statistics);
        return statistics;
    }




}
