package com.vaibhav.zookeeper.dynamic_spring_configuration.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class HelloUserService {

    @Autowired
    Environment environment;
    
    /**
     * Print the name property at the scheduled rate
     */
    @Scheduled(fixedRate=5000)
    public void greetUser() {
        String user = environment.getRequiredProperty("name");
        System.out.format("Hello %s!\n", user);
    }
}
