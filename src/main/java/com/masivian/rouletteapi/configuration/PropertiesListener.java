package com.masivian.rouletteapi.configuration;

import com.amazonaws.services.secretsmanager.AWSSecretsManager;
import com.amazonaws.services.secretsmanager.AWSSecretsManagerClientBuilder;
import com.amazonaws.services.secretsmanager.model.GetSecretValueRequest;
import com.amazonaws.services.secretsmanager.model.GetSecretValueResult;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.context.event.ApplicationPreparedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.PropertiesPropertySource;

import java.io.IOException;
import java.util.Properties;

public class PropertiesListener implements ApplicationListener<ApplicationPreparedEvent> {
    private final static String SPRING_DATASOURCE_URI = "spring.data.mongodb.uri";
    private final static String SPRING_DATASOURCE_DATABASE = "spring.data.mongodb.database";
    private ObjectMapper mapper = new ObjectMapper();

    @Override
    public void onApplicationEvent(ApplicationPreparedEvent event) {
        String secretJson = getSecret();
        String uri = getString(secretJson, "mongodb_uri");
        ConfigurableEnvironment environment = event.getApplicationContext().getEnvironment();
        Properties props = new Properties();
        props.put(SPRING_DATASOURCE_URI, uri);
        props.put(SPRING_DATASOURCE_DATABASE, System.getenv("DATABASE"));
        environment.getPropertySources().addFirst(new PropertiesPropertySource("aws.secret.manager", props));
    }

    public static String getSecret() {
        String secretName = "mongodb_uri";
        String region = "us-east-2";
        AWSSecretsManager client = AWSSecretsManagerClientBuilder.standard()
                .withRegion(region)
                .build();
        String secret = "";
        GetSecretValueRequest getSecretValueRequest = new GetSecretValueRequest()
                .withSecretId(secretName);
        GetSecretValueResult getSecretValueResult = null;

        try {
            getSecretValueResult = client.getSecretValue(getSecretValueRequest);
        } catch (Exception e) {
            System.out.println(e);
        }

        if (getSecretValueResult.getSecretString() != null) {
            secret = getSecretValueResult.getSecretString();
        }
        return secret;
    }

    private String getString(String json, String path) {
        try {
            JsonNode root = mapper.readTree(json);
            return root.path(path).asText();
        } catch (IOException e) {
            System.out.println(e);
            return null;
        }
    }
}
