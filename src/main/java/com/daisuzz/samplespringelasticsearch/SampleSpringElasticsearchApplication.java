package com.daisuzz.samplespringelasticsearch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.elasticsearch.ElasticsearchProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(ElasticsearchProperties.class)
public class SampleSpringElasticsearchApplication {

    public static void main(String[] args) {
        SpringApplication.run(SampleSpringElasticsearchApplication.class, args);
    }

}
