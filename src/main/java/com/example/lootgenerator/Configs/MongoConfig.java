package com.example.lootgenerator.Configs;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableMongoRepositories(basePackages = "com.example.lootgenerator.Repositories")
@Configuration
public class MongoConfig {
}
