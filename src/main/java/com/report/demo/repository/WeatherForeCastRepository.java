/**
 * 
 */
package com.report.demo.repository;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.report.demo.dto.OpenWeatherForecastDTO;

/**
 * @author vberlia
 *
 */

@ConditionalOnProperty(
		  name = "enableCaching", 
		  havingValue = "true")
public interface WeatherForeCastRepository extends MongoRepository<OpenWeatherForecastDTO, Long> {

}
