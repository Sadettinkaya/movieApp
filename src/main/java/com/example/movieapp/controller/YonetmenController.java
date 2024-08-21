package com.example.movieapp.controller;

import com.example.movieapp.dto.requestDto.yonetmenSaveDto;
import com.example.movieapp.service.yonetmenService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/yonetmen")
@RequiredArgsConstructor
public class YonetmenController {

    private final yonetmenService yonetmenservice;

    @PostMapping("/saveYonetmen")
    public ResponseEntity saveYonetmen(@RequestBody yonetmenSaveDto yonetmensavedto) {
        boolean bool =yonetmenservice.saveYonetmen(yonetmensavedto);
        return new ResponseEntity<>(bool, HttpStatus.OK);
    }
}

