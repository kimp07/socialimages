package org.senlacourse.images.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackages = "org.senlacourse.images.*")
@ComponentScan(basePackages = "org.senlacourse.images.*")
@PropertySource("classpath:application.properties")
@PropertySource("classpath:images.properties")
public class ImagesConfig {
}
