package com.example.movieapp.service;

import com.example.movieapp.dto.requestDto.categorySaveDto;
import com.example.movieapp.dto.requestDto.movieSaveDto;
import com.example.movieapp.entity.Category;
import com.example.movieapp.entity.Movie;
import com.example.movieapp.repository.categoryRepository;
import com.example.movieapp.repository.movieRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class categoryService {

    private final categoryRepository categoryrepository;
    private final ModelMapper modelMapper;

    public Boolean saveCategory(categorySaveDto categorysavedto) {
        Category category= modelMapper.map(categorysavedto, Category.class);
        categoryrepository.save(category);
        return true;
    }

}
