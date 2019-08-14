package com.report.demo.dto;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Document(collection ="weather_forecast")
public class OpenWeatherForecastDTO {
	
	
	@Id
	private Long _id;

	
	@JsonIgnore
    private String cod;
	@JsonIgnore
    private double message;
    private int cnt;
    private java.util.List<List> list;
    private City city;
 
	private long lastUpdated;
    public void setCod(String cod) {
         this.cod = cod;
     }
     public String getCod() {
         return cod;
     }

    public void setMessage(double message) {
         this.message = message;
     }
     public double getMessage() {
         return message;
     }

    public void setCnt(int cnt) {
         this.cnt = cnt;
     }
     public int getCnt() {
         return cnt;
     }

    public void setList(java.util.List<List> list) {
         this.list = list;
     }
     public java.util.List<List> getList() {
         return list;
     }

    public void setCity(City city) {
         this.city = city;
     }
     public City getCity() {
         return city;
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