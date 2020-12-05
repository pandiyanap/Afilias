package com.afilias.friendsrelationship.config;


import org.apache.catalina.filters.CorsFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    public void configure(WebSecurity webSecurity) {

        webSecurity.ignoring()
                .antMatchers(
                        "/shutdown",
                        "/metrics/**",
                        "/health",
                        "/api/v1/**",
                        "/friends/**",
                        "/info",
                        "/friends/**",
                        "/swagger-resources/**",
                        "/releaseVersion");
    }
}
