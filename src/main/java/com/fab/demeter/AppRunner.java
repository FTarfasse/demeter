package com.fab.demeter;

import com.fab.demeter.repositories.PlantRepository;
import org.hibernate.cfg.Environment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class AppRunner implements ApplicationRunner {

    private final static Logger log = LoggerFactory.getLogger(AppRunner.class);

    @Autowired
    private PlantRepository repository;

    @Value("${server.port}")
    private String port;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        this.log.info(System.lineSeparator());
        this.log.info("DEMETER API IS LIVE ON http://localhost:" + port);
        this.log.info(System.lineSeparator());
    }
}