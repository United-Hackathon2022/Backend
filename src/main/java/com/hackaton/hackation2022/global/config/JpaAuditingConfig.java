package com.hackaton.hackation2022.global.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@Configuration("com.hackaton.hackation2022")
public class JpaAuditingConfig {
}

