package com.example.movieapp.controller;

import com.example.movieapp.dto.requestDto.yonetmenSaveDto;
import com.example.movieapp.dto.requestDto.yonetmenUpdateDto;
import com.example.movieapp.dto.responseDto.movieByYonetmenResponseDto;
import com.example.movieapp.service.yonetmenService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/yonetmen")
@RequiredArgsConstructor
public class YonetmenController {

    private final yonetmenService yonetmenservice;

    @PutMapping("/updateYonetmen")
    public ResponseEntity<String>updateYonetmen(@RequestBody yonetmenUpdateDto yonetmenUpdatedto){
      String string=  yonetmenservice.updateYonetmen(yonetmenUpdatedto);
      return new ResponseEntity<>(string,HttpStatus.OK);
    }


    @PostMapping("/saveYonetmen")
    public ResponseEntity<Boolean> saveYonetmen(@RequestBody yonetmenSaveDto yonetmensavedto) {
        boolean bool =yonetmenservice.saveYonetmen(yonetmensavedto);
        return new ResponseEntity<>(bool, HttpStatus.OK);
    }
}

