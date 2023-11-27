package com.capstone.museumapi.controller;

import com.capstone.museumapi.model.Museum;
import com.capstone.museumapi.service.MuseumService;
import io.micrometer.common.util.StringUtils;
import jakarta.websocket.server.PathParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@Slf4j
@RestController
public class museumController {
    private MuseumService museumService;

    public museumController(MuseumService museumService) {
        this.museumService = museumService;
    }
    @GetMapping("/museums")
    public List<Museum> getAllMessages(@PathParam("filter") String filter){
        List<Museum> museums = Collections.emptyList();
        if(StringUtils.isNotBlank(filter)) {
            museums = museumService.findByMuseumNameContains(filter);
        }
        else {
            museums = museumService.findAll();
        }
        return museums;
    }
    @PostMapping("/museums")
    public Museum createMuseum(@RequestBody Museum museum){
        return museumService.save(museum);
    }
}
