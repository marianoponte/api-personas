package com.reba.api.persona.controller;

import com.reba.api.persona.dto.StatsDTO;
import com.reba.api.persona.service.StatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StatsController {

    @Autowired
    private StatsService statsService;

    @GetMapping("/stats")
    public List<StatsDTO> getStats() {
        return statsService.getStats();
    }
}

