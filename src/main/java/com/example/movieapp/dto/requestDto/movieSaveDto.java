package com.example.movieapp.dto.requestDto;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class movieSaveDto {

    private String film_adi;

    private int imdb;
}
