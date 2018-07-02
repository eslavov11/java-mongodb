package com.javamongodb.dataaccess.config;


import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackages = "com.javamongodb.dataaccess.repository")
public class MongoConfig extends AbstractMongoConfiguration {
    @Override
    protected String getDatabaseName() {
        return "cars";
    }

    @Override
    public MongoClient mongoClient() {
        return new MongoClient("localhost", 27017);
    }
}