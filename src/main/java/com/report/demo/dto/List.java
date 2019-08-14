package com.report.demo.dto;
import com.fasterxml.jackson.annotation.JsonProperty;
public class List {

    private int dt;
    private Main main;
    private java.util.List<Weather> weather;
    private Clouds clouds;
    private Wind wind;
    private Snow snow;
    private Sys sys;
    @JsonProperty("dt_txt")
    private String dtTxt;
    public void setDt(int dt) {
         this.dt = dt;
     }
     public int getDt() {
         return dt;
     }

    public void setMain(Main main) {
         this.main = main;
     }
     public Main getMain() {
         return main;
     }

    public void setWeather(java.util.List<Weather> weather) {
         this.weather = weather;
     }
     public java.util.List<Weather> getWeather() {
         return weather;
     }

    public void setClouds(Clouds clouds) {
         this.clouds = clouds;
     }
     public Clouds getClouds() {
         return clouds;
     }

    public void setWind(Wind wind) {
         this.wind = wind;
     }
     public Wind getWind() {
         return wind;
     }

    public void setSnow(Snow snow) {
         this.snow = snow;
     }
     public Snow getSnow() {
         return snow;
     }

    public void setSys(Sys sys) {
         this.sys = sys;
     }
     public Sys getSys() {
         return sys;
     }

    public void setDtTxt(String dtTxt) {
         this.dtTxt = dtTxt;
     }
     public String getDtTxt() {
         return dtTxt;
     }

}