package com.pjwstk.adudek;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RentalService {
    private final RestTemplate restTemplate;
    public RentalService(RestTemplate restTemplate) { this.restTemplate = restTemplate; }
    String movieServiceAddress = "http://localhost:8080/movies/";

    public Movie getMovie(Long id) {
        return restTemplate.getForObject(movieServiceAddress + id, Movie.class);
    }

    public void returnMovie(Long id) {
        restTemplate.put(movieServiceAddress + "isAvailable/" + id, null);
    }
}
