package com.capstone.museumapi.controller;

import com.capstone.museumapi.model.Sculpture;
import com.capstone.museumapi.service.ArtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/sculptures")
public class SculptureController {
    ArtService artService;
    @Autowired
    public SculptureController(ArtService artService) {
        this.artService = artService;
    }

    @GetMapping
    public List<Sculpture> getAllSculptures() {
        return artService.getAllSculptures();
    }
}

