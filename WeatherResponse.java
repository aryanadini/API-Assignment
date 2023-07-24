package com.springboot.app;

public class WeatherResponse {
    public double getTemperature() {
		return temperature;
	}
	public void setTemperature(double temperature) {
		this.temperature = temperature;
	}
	public int getHumidity() {
		return humidity;
	}
	public void setHumidity(int humidity) {
		this.humidity = humidity;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	private double temperature;
    private int humidity;
    private String description;
	public WeatherResponse(double temperature, int humidity, String description) {
		super();
		this.temperature = temperature;
		this.humidity = humidity;
		this.description = description;
	}

    // Constructors, getters, and setters
}

