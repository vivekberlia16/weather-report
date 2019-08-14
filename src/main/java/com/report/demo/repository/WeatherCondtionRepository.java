package com.report.demo.repository;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.report.demo.dto.OpenWeatherConditionsDTO;

@ConditionalOnProperty(
		  name = "enableCaching", 
		  havingValue = "true")
public interface WeatherCondtionRepository extends MongoRepository<OpenWeatherConditionsDTO, Long> {

}
