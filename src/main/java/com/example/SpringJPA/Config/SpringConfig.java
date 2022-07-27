package com.example.SpringJPA.Config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration //Spring Configs
public class SpringConfig {
    @Bean
    public ModelMapper modelMapper() { //Used for mapping Entity to DTOs
        return new ModelMapper();
    }
}
