package com.report.demo.dto;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Document(collection ="weather_conditions")
public class OpenWeatherConditionsDTO {
	
	@Id
	private Long _id;
    private Coord coord;
    private List<Weather> weather;
    @JsonIgnore
    private String base;
    private Main main;
    private int visibility;
    private Wind wind;
    private Clouds clouds;
    private int dt;
    private Sys sys;
    private int id;
    private String name;
    private int cod;
    private long lastUpdated;
    public void setCoord(Coord coord) {
         this.coord = coord;
     }
     public Coord getCoord() {
         return coord;
     }

    public void setWeather(List<Weather> weather) {
         this.weather = weather;
     }
     public List<Weather> getWeather() {
         return weather;
     }

    public void setBase(String base) {
         this.base = base;
     }
     public String getBase() {
         return base;
     }

    public void setMain(Main main) {
         this.main = main;
     }
     public Main getMain() {
         return main;
     }

    public void setVisibility(int visibility) {
         this.visibility = visibility;
     }
     public int getVisibility() {
         return visibility;
     }

    public void setWind(Wind wind) {
         this.wind = wind;
     }
     public Wind getWind() {
         return wind;
     }

    public void setClouds(Clouds clouds) {
         this.clouds = clouds;
     }
     public Clouds getClouds() {
         return clouds;
     }

    public void setDt(int dt) {
         this.dt = dt;
     }
     public int getDt() {
         return dt;
     }

    public void setSys(Sys sys) {
         this.sys = sys;
     }
     public Sys getSys() {
         return sys;
     }

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

    public void setCod(int cod) {
         this.cod = cod;
     }
     public int getCod() {
         return cod;
     }
	public Long get_id() {
		return _id;
	}
	public void set_id(Long _id) {
		this._id = _id;
	}
	public long getLastUpdated() {
		return lastUpdated;
	}
	public void setLastUpdated(long lastUpdated) {
		this.lastUpdated = lastUpdated;
	}
     
 

}