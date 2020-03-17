package com.example.demoRestApp.configurations;

import com.example.demoRestApp.repository.StudentRepository;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories (basePackageClasses = StudentRepository.class)
public class MongoDBConfig {

}
