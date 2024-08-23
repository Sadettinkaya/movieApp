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

    //request dtoyu client verdi bizde onu kaydettik veri tabanına bool döndürdük cliente
    @PostMapping("/saveMovie")
    public ResponseEntity<Boolean> saveMovie(@RequestBody movieSaveDto moviesavedto) {
        Boolean bool = movieservice.saveMovie(moviesavedto);
        return new ResponseEntity<>(bool, HttpStatus.CREATED);
    }
    //yonetmenId sine göre response dto dönüyor clienta
    @GetMapping("getMovieByYonetmenId")
    public ResponseEntity<List<movieByYonetmenResponseDto>> findAllMovieByYonetmenId(@RequestParam Long yonetmenId){
        //findAllMovieByYonetmenId methodunu jpanın anlıcağı şekilde yazdık oda arka tarafta sorguyu oluşturdu
        List<movieByYonetmenResponseDto>list = movieservice.findAllMovieByYonetmenId(yonetmenId);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @DeleteMapping("/deleteMovieId")
    public ResponseEntity<Boolean> deleteMovieId(@RequestParam Long movieId) {
        Boolean bool = movieservice.deleteMovieId(movieId);
        return new ResponseEntity<>(bool, HttpStatus.OK);
    }
}
