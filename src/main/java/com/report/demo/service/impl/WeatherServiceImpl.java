package com.report.demo.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.report.demo.dto.OpenWeatherConditionsDTO;
import com.report.demo.dto.OpenWeatherForecastDTO;
import com.report.demo.exceptions.WeatherAppException;
import com.report.demo.repository.WeatherCondtionRepository;
import com.report.demo.repository.WeatherForeCastRepository;
import com.report.demo.service.IWeatherService;
import com.report.demo.utils.AppConstants;
import com.report.demo.utils.ServiceUtils;

@Service
public class WeatherServiceImpl<E> implements IWeatherService {

	private Logger logger = LoggerFactory.getLogger(WeatherServiceImpl.class);
	@Value("${openapi.appKey}")
	private String appKey;

	@Autowired(required = false)
	WeatherForeCastRepository weatherForeCastRepository;

	@Autowired(required = false)
	WeatherCondtionRepository weatherCondtionRepository;

	@Value("${enableCaching}")
	private boolean isCachingEnabled;

	@Value("${cacheFrequency}")
	private double cacheFrequency;

	@Override
	public OpenWeatherForecastDTO getWeatherForecastByCityId(String cityId) throws WeatherAppException {
		OpenWeatherForecastDTO openWeatherForecastDTO = null;
		try {
			if (isCachingEnabled && weatherForeCastRepository.findById(Long.valueOf(cityId)).isPresent()) {

				OpenWeatherForecastDTO op = weatherForeCastRepository.findById(Long.valueOf(cityId)).get();
				Long currentTime = System.currentTimeMillis();
				Long lastUpdated = op.getLastUpdated();
				if ((currentTime - lastUpdated) / (1000 * 60 * 60) < cacheFrequency) {
					logger.info("Returning cached weather forecast" + cityId);
					return op;
				}

			}
			RestTemplate restTemplate = new RestTemplate();
			UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(AppConstants.OPEN_WEATHER_FORECAST_URI)
					.queryParam(AppConstants.CITY_KEY_STR, cityId).queryParam(AppConstants.APP_ID_STR, appKey);
			logger.info("uri string for weather forecast" + uriBuilder.toUriString());
			ResponseEntity<OpenWeatherForecastDTO> responseEntity = restTemplate.exchange(uriBuilder.toUriString(),
					HttpMethod.GET, new HttpEntity<>(new HttpHeaders()), OpenWeatherForecastDTO.class);
			logger.info("response Entity status code" + responseEntity.getStatusCode());
			if (responseEntity.getStatusCode() == HttpStatus.OK) {
				logger.info("=======response received from weather forecast API========"
						+ ServiceUtils.convertObjToJson(responseEntity.getBody()));
				openWeatherForecastDTO = responseEntity.getBody();

				if (isCachingEnabled) {
					openWeatherForecastDTO.set_id(Long.valueOf(cityId));
					openWeatherForecastDTO.setLastUpdated(System.currentTimeMillis());
					weatherForeCastRepository.save(openWeatherForecastDTO);

				}

			}

		} catch (RestClientException restClientException) {
			logger.info("Got Excpetion in open service API" + restClientException.getCause());
			throw new WeatherAppException(503, restClientException.getMessage());
		}
		return openWeatherForecastDTO;
	}

	@Override
	public OpenWeatherConditionsDTO getWeatherConditionsByCityId(String cityId) throws WeatherAppException {
		OpenWeatherConditionsDTO openWeatherConditionsDTO = null;
		try {
			if (isCachingEnabled && weatherCondtionRepository.findById(Long.valueOf(cityId)).isPresent()) {
				OpenWeatherConditionsDTO op = weatherCondtionRepository.findById(Long.valueOf(cityId)).get();
				Long currentTime = System.currentTimeMillis();
				Long lastUpdated = op.getLastUpdated();
				if ((currentTime - lastUpdated) / (1000 * 60 * 60) < cacheFrequency) {
					logger.info("Returning cached weather conditions" + cityId);
					return op;
				}

			}
			RestTemplate restTemplate = new RestTemplate();
			UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(AppConstants.OPEN_WEATHER_CONDTIONS_URI)
					.queryParam(AppConstants.CITY_KEY_STR, cityId).queryParam(AppConstants.APP_ID_STR, appKey);

			logger.info("uri string for weather conditions" + uriBuilder.toUriString());
			ResponseEntity<OpenWeatherConditionsDTO> responseEntity = restTemplate.exchange(uriBuilder.toUriString(),
					HttpMethod.GET, new HttpEntity<>(new HttpHeaders()), OpenWeatherConditionsDTO.class);
			logger.info("response Entity code" + responseEntity.getStatusCode());
			if (responseEntity.getStatusCode() == HttpStatus.OK) {
				logger.info("=====response received from weather conditions API====="
						+ ServiceUtils.convertObjToJson(responseEntity.getBody()));

				openWeatherConditionsDTO = responseEntity.getBody();
				if (isCachingEnabled) {
					openWeatherConditionsDTO.set_id(Long.valueOf(cityId));
					openWeatherConditionsDTO.setLastUpdated(System.currentTimeMillis());
					weatherCondtionRepository.save(openWeatherConditionsDTO);
				}

			}

		} catch (RestClientException restClientException) {
			logger.info("Got Excpetion in open service API" + restClientException.getCause());
			throw new WeatherAppException(503, restClientException.getMessage());
		}
		return openWeatherConditionsDTO;
	}
}
