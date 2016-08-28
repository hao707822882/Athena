package com.boom.athean;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author Eric
 */
@Configuration
@EnableAutoConfiguration
@ComponentScan("com.boom.athean")
@EnableJpaRepositories("com.boom.athean.dao")
@EnableTransactionManagement
@EntityScan("com.boom.athean.model")
@ImportResource(value = {"classpath:META-INF/spring/angel-athean-consumer.xml"})
public class AthenaView {

    public static void main(String[] args) {
        SpringApplication.run(AthenaView.class, args);
    }

}
