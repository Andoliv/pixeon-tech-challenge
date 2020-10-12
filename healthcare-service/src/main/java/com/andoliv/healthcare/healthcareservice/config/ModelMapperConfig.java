package com.andoliv.healthcare.healthcareservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * The ModelMapper Config class is responsible to mapper entities to external objects and vice versa
 *
 * @author anderson.oliveira
 */
@Configuration
public class ModelMapperConfig {

    @Bean
    public org.modelmapper.ModelMapper modelMapper() {
        return new org.modelmapper.ModelMapper();
    }

}
