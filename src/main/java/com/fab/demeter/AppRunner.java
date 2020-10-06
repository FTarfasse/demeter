package com.fab.demeter;

import com.fab.demeter.models.PlantRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class AppRunner implements ApplicationRunner {

    private final static Logger log = LoggerFactory.getLogger(AppRunner.class);

    @Autowired
    private PlantRepository repository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        this.log.info("Let's roll out !");
    }
}