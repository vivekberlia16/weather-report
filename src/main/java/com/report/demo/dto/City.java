package com.report.demo.dto;
public class City {

    private int id;
    private String name;
    private Coord coord;
    private String country;
    public void setId(int id) {
         this.id = id;
     }
     public int getId() {
         return id;
     }

    public void setName(String name) {
         this.name = name;
     }
     public String getName() {
         return name;
     }

    public void setCoord(Coord coord) {
         this.coord = coord;
     }
     public Coord getCoord() {
         return coord;
     }

    public void setCountry(String country) {
         this.country = country;
     }
     public String getCountry() {
         return country;
     }

}