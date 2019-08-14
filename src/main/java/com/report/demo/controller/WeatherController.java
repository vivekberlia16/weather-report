package com.report.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.report.demo.utils.AppConstants;
import com.report.demo.dto.OpenWeatherConditionsDTO;
import com.report.demo.dto.OpenWeatherForecastDTO;
import com.report.demo.exceptions.WeatherAppException;
import com.report.demo.service.IWeatherService;

@RequestMapping("/weather")
@RestController
public class WeatherController {
	
	@Autowired
	IWeatherService weatherService;
	
	
	@RequestMapping(value = AppConstants.GET_WEATHER_CONDTIONS_BY_CITY, method =RequestMethod.GET)
	public OpenWeatherConditionsDTO getWeatherConditionsByCityId(@PathVariable String cityId) throws WeatherAppException {
		
		return weatherService.getWeatherConditionsByCityId(cityId);
	}
	
	
	@RequestMapping(value=AppConstants.GET_WEATHER_FORECAST_BY_CITY, method= RequestMethod.GET)
	public OpenWeatherForecastDTO getWeatherForecastByCityId(@PathVariable String cityId) throws WeatherAppException {
		return  weatherService.getWeatherForecastByCityId(cityId);
	}
}
