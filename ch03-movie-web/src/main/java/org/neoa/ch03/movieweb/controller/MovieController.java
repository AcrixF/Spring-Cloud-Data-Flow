package org.neoa.ch03.movieweb.controller;

import org.neoa.ch03.movieweb.model.Movie;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MovieController {

    private static final Logger log = LoggerFactory.getLogger(MovieController.class);

    @PostMapping(value = "/v1/movie")
    public ResponseEntity<String> movie(@RequestBody Movie movie) {
        log.info("Movie: {} ", movie);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @PostMapping(value = "/v1/movies")
    public ResponseEntity<String> movie(@RequestBody Movie[] movies) {

        for (Movie movie: movies) {
            log.info("Movie: {} ", movie);
        }
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}
