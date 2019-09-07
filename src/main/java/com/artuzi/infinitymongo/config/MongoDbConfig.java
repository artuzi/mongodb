package com.artuzi.infinitymongo.config;

import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableMongoRepositories(basePackages = {"com.artuzi.infinitymongo.dao"})
public class MongoDbConfig {

}
