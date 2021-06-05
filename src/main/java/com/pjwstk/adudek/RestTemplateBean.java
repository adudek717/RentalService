package com.pjwstk.adudek;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateBean {

    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
