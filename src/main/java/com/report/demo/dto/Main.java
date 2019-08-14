package com.report.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Main {

    private double temp;
    @JsonProperty("temp_min")
    private double tempMin;
    @JsonProperty("temp_max")
    private double tempMax;
    private double pressure;
    @JsonProperty("sea_level")
    private double seaLevel;
    @JsonProperty("grnd_level")
    private double grndLevel;
    private int humidity;
    @JsonProperty("temp_kf")
    private double tempKf;
    public void setTemp(double temp) {
         this.temp = temp;
     }
     public double getTemp() {
         return temp;
     }

    public void setTempMin(double tempMin) {
         this.tempMin = tempMin;
     }
     public double getTempMin() {
         return tempMin;
     }

    public void setTempMax(double tempMax) {
         this.tempMax = tempMax;
     }
     public double getTempMax() {
         return tempMax;
     }

    public void setPressure(double pressure) {
         this.pressure = pressure;
     }
     public double getPressure() {
         return pressure;
     }

    public void setSeaLevel(double seaLevel) {
         this.seaLevel = seaLevel;
     }
     public double getSeaLevel() {
         return seaLevel;
     }

    public void setGrndLevel(double grndLevel) {
         this.grndLevel = grndLevel;
     }
     public double getGrndLevel() {
         return grndLevel;
     }

    public void setHumidity(int humidity) {
         this.humidity = humidity;
     }
     public int getHumidity() {
         return humidity;
     }

    public void setTempKf(double tempKf) {
         this.tempKf = tempKf;
     }
     public double getTempKf() {
         return tempKf;
     }

}