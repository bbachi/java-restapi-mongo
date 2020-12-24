package com.bachinalabs.mongodemo.config;

import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Configuration
public class SSLConfig {

    @PostConstruct
    private void configureSSL() {

        System.setProperty("https.protocols", "TLSv1.2");
    }
}
