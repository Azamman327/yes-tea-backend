package com.example.tea_backend.controller;

import com.example.tea_backend.domain.Teas;
import com.example.tea_backend.repository.TeasRepository;
import com.example.tea_backend.service.TeasService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000", allowedHeaders = "*")
@Controller
@RequestMapping(path="/teas")
@Slf4j
public class TeasController {
    @Autowired
    private TeasRepository teasRepository;
    @Autowired
    private TeasService teasService;

    @PostMapping(path="/create")
    public @ResponseBody Long createTea(@RequestBody Teas request) {
        return teasService.createTea(request);
    }

    @PutMapping(path="/update")
    public @ResponseBody Long updateTea(@RequestBody Teas request) {
        return teasService.updateTea(request);
    }
}
