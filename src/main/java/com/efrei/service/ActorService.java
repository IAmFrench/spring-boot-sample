package com.efrei.service;

import com.efrei.model.Actor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class ActorService {

    public List<Actor> getMovieActors(String movieTitle) {
        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<Actor[]> entity = restTemplate.getForEntity("http://localhost:8081/actors/" + movieTitle, Actor[].class);

        if (entity != null) {
            return Arrays.asList(entity.getBody());
        } else {
            return Collections.emptyList();
        }
    }

}