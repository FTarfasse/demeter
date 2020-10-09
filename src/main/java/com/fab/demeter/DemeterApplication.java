package com.fab.demeter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;

@SpringBootApplication
public class DemeterApplication {

    @Value("${server.port}")
    private String port;

    private static final Logger log = LoggerFactory.getLogger(DemeterApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(DemeterApplication.class, args);
    }

    @Bean
    CommandLineRunner init(){
        return args -> {
            this.log.info(System.lineSeparator());
            this.log.info("DEMETER API IS LIVE ON http://localhost:" + port);
            this.log.info(System.lineSeparator());
        };
    }

}
