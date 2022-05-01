package org.neoa.ch03.integration.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.neoa.ch03.integration.model.Movie;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class MovieService {

    private static final Logger log = LoggerFactory.getLogger(MovieService.class);

    public String format(String contents) {
        log.info("Formatting to Json...");

        String json = "{}";
        ObjectMapper mapper = new ObjectMapper();

        try {
            json = mapper.writeValueAsString(parse(contents));
            log.info("\n {} \n", json);
        } catch (IOException error) {
            error.printStackTrace();
        }

        return json;
    }

    private List<Movie> parse(String contents) {

        String[] record = null;
        List<Movie> movies = new ArrayList<>();
        for(String line: contents.split(System.getProperty("line.separator"))) {
            record = Arrays.stream(line.split(",")).map(String::trim).toArray(String[]::new);
            movies.add(new Movie(record[0], record[1], Integer.parseInt(record[2])));
        }
        return movies;
    }
}

