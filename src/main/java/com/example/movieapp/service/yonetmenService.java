package com.example.movieapp.service;

import com.example.movieapp.dto.requestDto.yonetmenSaveDto;
import com.example.movieapp.entity.Yonetmen;
import com.example.movieapp.repository.yonetmenRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class yonetmenService {

    private final yonetmenRepository yonetmenrepository;
    private final ModelMapper modelMapper;

    public boolean saveYonetmen(yonetmenSaveDto yonetmensavedto) {
        Yonetmen yonetmen= modelMapper.map(yonetmensavedto, Yonetmen.class);
        yonetmenrepository.save(yonetmen);
        return true;

    }


}
