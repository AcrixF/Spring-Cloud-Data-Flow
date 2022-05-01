package org.neoa.ch03.integration.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource("META-INFO/spring/movie-app-integration.xml")
public class MovieConfiguration {
}
