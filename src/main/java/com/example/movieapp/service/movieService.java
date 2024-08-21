package com.example.movieapp.service;

import com.example.movieapp.dto.requestDto.movieSaveDto;
import com.example.movieapp.entity.Movie;
import com.example.movieapp.repository.movieRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class movieService {

    private final movieRepository movierepository;
    private final ModelMapper modelMapper;

    public Boolean saveMovie(movieSaveDto moviesavedto) {
       Movie movie= modelMapper.map(moviesavedto, Movie.class);
        movierepository.save(movie);
        return true;
    }
}
