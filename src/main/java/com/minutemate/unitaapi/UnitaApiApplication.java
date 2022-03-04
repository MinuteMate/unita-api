package com.minutemate.unitaapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;

@SpringBootApplication
@EnableRedisRepositories
public class UnitaApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(UnitaApiApplication.class, args);
    }

}
