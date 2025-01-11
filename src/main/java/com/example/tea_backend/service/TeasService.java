package com.example.tea_backend.service;

import com.example.tea_backend.domain.Teas;
import com.example.tea_backend.repository.TeasRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
public class TeasService {
    @Autowired
    private TeasRepository teasRepository;

    public Long updateTea(Teas request) {
        log.info("teaId log={}", request.getTeaId());
        Teas teas = teasRepository.findById(request.getTeaId()).orElseThrow(() -> new RuntimeException("Entity not found with id"));

        teas.setBrand(request.getBrand());
        teas.setName(request.getName());
        teas.setPackagingtype(request.getPackagingtype());
        teas.setType(request.getType());
        teas.setMinute(request.getMinute());
        teas.setSecond(request.getSecond());
        teas.setTemperature(request.getTemperature());
        teas.setQuantity(request.getQuantity());
        teas.setWatervolume(request.getWatervolume());

        Teas updatedTea = teasRepository.save(teas);
        return updatedTea.getTeaId();
    }
}
