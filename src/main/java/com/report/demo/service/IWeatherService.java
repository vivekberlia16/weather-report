package com.report.demo.service;

import com.report.demo.dto.OpenWeatherConditionsDTO;
import com.report.demo.dto.OpenWeatherForecastDTO;
import com.report.demo.exceptions.WeatherAppException;

public interface IWeatherService {
	
	public  OpenWeatherForecastDTO getWeatherForecastByCityId(String cityId) throws WeatherAppException;
	public OpenWeatherConditionsDTO getWeatherConditionsByCityId(String cityId) throws WeatherAppException;

}
