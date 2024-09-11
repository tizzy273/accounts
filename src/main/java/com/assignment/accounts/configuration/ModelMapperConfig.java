package com.assignment.accounts.configuration;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Configuration class for {@link ModelMapper}.
 */
@Configuration
public class ModelMapperConfig {

    /**
     * Provides a {@link ModelMapper} bean.
     *
     * @return a {@link ModelMapper} instance
     */
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

}
