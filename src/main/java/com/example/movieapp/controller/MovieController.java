package com.example.movieapp.controller;

import com.example.movieapp.dto.requestDto.movieSaveDto;
import com.example.movieapp.dto.responseDto.movieByYonetmenResponseDto;
import com.example.movieapp.service.movieService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movie")
@RequiredArgsConstructor
public class MovieController {

    private final movieService movieservice;

    @PostMapping("/saveMovie")
    public ResponseEntity<Boolean> saveMovie(@RequestBody movieSaveDto moviesavedto) {
        Boolean bool=  movieservice.saveMovie(moviesavedto);
        return new ResponseEntity<>(bool, HttpStatus.CREATED);
    }

    @GetMapping("getMovieByYonetmenId")
    public ResponseEntity<List<movieByYonetmenResponseDto>> findAllMovieByYonetmenId(@RequestParam Long yonetmenId){
     List<movieByYonetmenResponseDto>  list=  movieservice.findAllMovieByYonetmenId(yonetmenId);
     return new ResponseEntity<>(list, HttpStatus.OK);
    }
}
