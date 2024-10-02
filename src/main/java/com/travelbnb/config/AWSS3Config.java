package com.travelbnb.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AWSS3Config {

    @Value("${}")
    private String accessKey;

    @Value("${}")
    private String secretkey;

    @Value("${}")
    private String region;





}
