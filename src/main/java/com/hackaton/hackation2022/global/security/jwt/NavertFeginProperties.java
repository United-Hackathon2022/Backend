package com.hackaton.hackation2022.global.security.jwt;

import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

@Getter
@ConfigurationProperties(prefix = "auth.naver")
@ConstructorBinding
public class NavertFeginProperties {
    private final String clientId;
    private final String clientSecret;
    private final String state;

    public NavertFeginProperties(String clientId, String clientSecret, String state) {
        this.clientId = clientId;
        this.clientSecret = clientSecret;
        this.state = state;
    }
}
