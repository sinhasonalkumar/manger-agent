package com.sonal.manager.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.MongoClient;

@Configuration
@EnableMongoRepositories(basePackages = { "com.sonal.manager.persistence" })
public class MongoConfig {
	

	@Bean
	public MongoClient mongo() {
		MongoClient client = new MongoClient("127.0.0.1",27017);
		return client;
	}

	@Bean
	public MongoTemplate mongoTemplate() {
		String databaseName = "jobDB";
		MongoTemplate mongoTemplate = new MongoTemplate(mongo(), databaseName);
		return mongoTemplate;
	}
}
