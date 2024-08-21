package com.example.movieapp.controller;

import com.example.movieapp.service.movieService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movie")
@RequiredArgsConstructor
public class MovieController {

    private final movieService movieService;

    @GetMapping("/getmovie")
    public ResponseEntity getMovie() {
        return null;
    }
}
