package com.capstone.museumapi.controller;

import com.capstone.museumapi.model.Museum;
import com.capstone.museumapi.service.MuseumService;
import io.micrometer.common.util.StringUtils;
import jakarta.websocket.server.PathParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@Slf4j
@RestController
public class MuseumController {
    private MuseumService museumService;

    public MuseumController(MuseumService museumService) {
        this.museumService = museumService;
    }
    @GetMapping("/museums")
    public List<Museum> getAllMuseums(@PathParam("filter") String filter){
        List<Museum> museums = Collections.emptyList();
        if(StringUtils.isNotBlank(filter)) {
            museums = museumService.findByMuseumNameContains(filter);
        }
        else {
            museums = museumService.findAll();
        }
        return museums;
    }
    @PostMapping("/museum")
    public Museum createMuseum(@RequestBody Museum museum){
        return museumService.save(museum);
    }
    @DeleteMapping("/museum/{id}")
    public ResponseEntity<String> deleteMessage(@PathVariable Integer id) {
        museumService.deleteMuseum(id);
        return new ResponseEntity<>("Museum deleted successfully", HttpStatus.OK);
    }
    @GetMapping("/museums/{id}")
    public Museum getMuseum(@PathVariable int id) {
        return museumService.findById(id);
    }
}
