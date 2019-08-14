package com.report.demo.dto;

public class Sys {

    private int type;
    private int id;
    private double message;
    private String country;
    private int sunrise;
    private int sunset;
    private String pod;
    public void setPod(String pod) {
         this.pod = pod;
     }
     public String getPod() {
         return pod;
     }
    public void setType(int type) {
         this.type = type;
     }
     public int getType() {
         return type;
     }

    public void setId(int id) {
         this.id = id;
     }
     public int getId() {
         return id;
     }

    public void setMessage(double message) {
         this.message = message;
     }
     public double getMessage() {
         return message;
     }

    public void setCountry(String country) {
         this.country = country;
     }
     public String getCountry() {
         return country;
     }

    public void setSunrise(int sunrise) {
         this.sunrise = sunrise;
     }
     public int getSunrise() {
         return sunrise;
     }

    public void setSunset(int sunset) {
         this.sunset = sunset;
     }
     public int getSunset() {
         return sunset;
     }

}