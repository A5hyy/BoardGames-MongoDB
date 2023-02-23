package bggMongoDB.SpringBoot.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

// This is the Configuration for the MongoDb Database
@Configuration
public class MongoConfig {

    @Value("mongodb+srv://ash:Acapthecool%401@cluster0.yvalyga.mongodb.net/test")
    private String mongoUrl;

    @Bean
    public MongoClient mongoClient(){
        return MongoClients.create(mongoUrl);
    }

    @Bean
    public MongoTemplate mongoTemplate(){
        // " ??? " is the database name
        return new MongoTemplate(mongoClient(), "gamedatabase");
    }
    
}

//mongodb+srv://ash:<password>@cluster0.yvalyga.mongodb.net/test