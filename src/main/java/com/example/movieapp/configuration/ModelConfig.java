package com.example.movieapp.configuration;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelConfig {

    //dto yu entitiye çevirip reposityde işlem yapabilmek için modelmappar kullanıyoruz çevirme işlemini yapar
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
