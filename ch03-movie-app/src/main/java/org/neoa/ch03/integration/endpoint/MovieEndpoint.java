package org.neoa.ch03.integration.endpoint;

import lombok.extern.log4j.Log4j;
import org.neoa.ch03.integration.services.MovieService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.util.StreamUtils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Map;

@MessageEndpoint
public class MovieEndpoint {

    private static final Logger log = LoggerFactory.getLogger(MovieEndpoint.class);

    private final MovieService movieService;

    @Autowired
    public MovieEndpoint(MovieService movieService) {
        this.movieService = movieService;
    }

    @ServiceActivator
    public Message<String> process(File input, @Headers Map<String, Object> headers) throws Exception {
        FileInputStream inputStream = new FileInputStream(input);
        String movies = movieService.format(new String(StreamUtils.copyToByteArray(inputStream)));
        inputStream.close();
        log.info("Sending the JSON content to a file...");
        return MessageBuilder.withPayload(movies)
                .setHeader("name", input.getName())
                .setHeader("Content-Type", "application/json")
                .build();
    }
}
