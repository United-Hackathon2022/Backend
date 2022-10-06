package com.hackaton.hackation2022.global.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hackaton.hackation2022.global.security.jwt.JwtTokenProvider;
import com.hackaton.hackation2022.global.security.jwt.filter.JwtFilterConfig;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsUtils;

import javax.servlet.FilterConfig;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {


    private final JwtTokenProvider jwtTokenProvider;
    private final ObjectMapper objectMapper;
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .formLogin().disable()
                .cors()

                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)

                .and()
                .authorizeRequests()
                .requestMatchers(CorsUtils::isPreFlightRequest).permitAll()

                .antMatchers(HttpMethod.POST, "/feeds").permitAll()
                .antMatchers(HttpMethod.GET, "/feeds/list").permitAll()
                .antMatchers(HttpMethod.GET, "/feeds/{feed-id}").permitAll()

                .antMatchers(HttpMethod.GET, "/feeds/token").permitAll()

                .antMatchers(HttpMethod.GET, "/users").permitAll()

                .antMatchers(HttpMethod.POST, "/comments/{feed-id}").permitAll()

                .antMatchers(HttpMethod.GET, "/auth/naver/redirect").permitAll()

                .anyRequest().denyAll()

                .and()
                .apply(new JwtFilterConfig(jwtTokenProvider, objectMapper));


        return http.build();
    }
}
