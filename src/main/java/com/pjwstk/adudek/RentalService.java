package com.pjwstk.adudek;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RentalService {
    private final RestTemplate restTemplate;
    private final String movieServiceAddress;

    public RentalService(RestTemplate restTemplate, @Value("${service.movie.address}") String movieServiceAddress) {
        this.restTemplate = restTemplate;
        this.movieServiceAddress = movieServiceAddress;
    }

    public Movie getMovie(Long id) {
        String url = movieServiceAddress + "/movies/" + id;
        return restTemplate.getForObject(url, Movie.class);
    }

    public void returnMovie(Long id) {
        String url = movieServiceAddress + "/movies/isAvailable/" + id;
        restTemplate.put(url, null);
    }
}
