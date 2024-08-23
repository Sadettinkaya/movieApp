package com.example.movieapp.service;

import com.example.movieapp.dto.requestDto.yonetmenSaveDto;
import com.example.movieapp.dto.requestDto.yonetmenUpdateDto;
import com.example.movieapp.entity.Yonetmen;
import com.example.movieapp.repository.yonetmenRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

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

    public String updateYonetmen(yonetmenUpdateDto yonetmenUpdatedto) {
        Long id=yonetmenUpdatedto.getId(); //idyi aldık
        String yonetmenname = yonetmenUpdatedto.getYonetmen_adi();
        Optional<Yonetmen> yonetmen = yonetmenrepository.findById(id); //idye göre yonetmeni çektik
        if(yonetmen.isPresent()) {
            Yonetmen yonetmen1=yonetmen.get(); //yonetmen1 ile yönetmen nesnesini aldık
            yonetmen1.setYonetmen_adi(yonetmenname);
            yonetmenrepository.save(yonetmen1);
            return "true";
        }
        return String.format("%s id'sine sahip bir yonetmen bulunmamaktadır",id);
    }
}
