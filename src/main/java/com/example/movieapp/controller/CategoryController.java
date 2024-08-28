
package com.example.movieapp.controller;

import com.example.movieapp.dto.requestDto.categorySaveDto;
import com.example.movieapp.dto.requestDto.movieSaveDto;
import com.example.movieapp.service.categoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/category")
@RequiredArgsConstructor
public class CategoryController {

    private final categoryService categoryservice;

    @PostMapping("/saveCategory")
    public ResponseEntity<Boolean> saveCategory(@RequestBody categorySaveDto categorysavedto) {
        Boolean bool=  categoryservice.saveCategory(categorysavedto);
        return new ResponseEntity<>(bool, HttpStatus.CREATED);
    }

}
