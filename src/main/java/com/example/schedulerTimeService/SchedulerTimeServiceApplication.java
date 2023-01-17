package com.example.schedulerTimeService;

import com.example.schedulerTimeService.config.ConfigProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@EnableConfigurationProperties(ConfigProperties.class)
public class SchedulerTimeServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(SchedulerTimeServiceApplication.class, args);
    }

}
