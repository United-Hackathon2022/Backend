package com.hackaton.hackation2022.global.config;

import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.Configuration;

@ConfigurationPropertiesScan("com.hackaton.hackation2022.global.security.jwt")
@Configuration
public class ConfigurationPropertiesConfig {
}
