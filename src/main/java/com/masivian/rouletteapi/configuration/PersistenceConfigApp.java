package com.masivian.rouletteapi.configuration;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;

@Configuration
public class PersistenceConfigApp extends AbstractMongoConfiguration {
    @Value("${spring.datasource.database}")
    private String database;
    @Value("${spring.datasource.host}")
    private String host;
    @Value("${spring.datasource.port}")
    private String port;
    @Value("${spring.datasource.username}")
    private String username;
    @Value("${spring.datasource.password}")
    private String password;


    @Override
    @Bean
    public MongoClient mongoClient() {
        MongoClientURI uri = new MongoClientURI(
                "mongodb+srv://egherrera:Colombia.2019@roulette-api.h52h6.mongodb.net/roulette-api?retryWrites=true&w=majority");

        return new MongoClient(uri);
    }

    @Override
    protected String getDatabaseName() {
        return "roulette-api";
    }

    @Override
    protected String getMappingBasePackage() {
        return "org.baeldung";
    }
}
