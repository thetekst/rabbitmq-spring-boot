package ru.tkachenko.app.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Dmitry Tkachenko on 19.04.18
 */
@Configuration
public class ApplicationConfig {

    @Autowired
    private ObjectMapper objectMapper;

    @Bean
    public Jackson2JsonMessageConverter jackson2JsonMessageConverter() {
        return new Jackson2JsonMessageConverter(objectMapper);
    }

}
