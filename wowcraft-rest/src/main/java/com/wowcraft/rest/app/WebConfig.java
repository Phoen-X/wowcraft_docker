package com.wowcraft.rest.app;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedMethods(Stream.of(HttpMethod.values())
                                      .map(HttpMethod::name)
                                      .collect(toList())
                                      .toArray(new String[]{}));
    }


}
