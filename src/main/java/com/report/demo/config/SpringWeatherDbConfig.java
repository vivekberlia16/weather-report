package com.report.demo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.MongoClient;

@Configuration
@ConditionalOnProperty(name = "enableCaching", havingValue = "true")
@EnableMongoRepositories(basePackages = { "com.report.demo.repository" })
@ComponentScan({ "com.report.demo" })
@PropertySource({"classpath:application.properties"})
public class SpringWeatherDbConfig {
	
	@Value("${mongo-hostname}")
	String hostName;

	@Value("${dbName}")
	String dbName;

	@Bean
	@ConditionalOnProperty(name = "enableCaching", havingValue = "true")
	public MongoClient mongo() {
		return new MongoClient(hostName);
	}

	@Bean
	@ConditionalOnProperty(name = "enableCaching", havingValue = "true")
	public MongoTemplate mongoTemplate() throws Exception {
		return new MongoTemplate(mongo(), dbName);
	}
	


}
