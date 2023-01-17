package com.example.schedulerTimeService.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties("scheduler")
public class ConfigProperties {

    private String time;

}
