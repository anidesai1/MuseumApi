package com.capstone.museumapi.controller;

import com.capstone.museumapi.dto.MuseumDto;
import com.capstone.museumapi.model.Exhibition;
import com.capstone.museumapi.model.Museum;
import com.capstone.museumapi.service.MuseumService;
import com.capstone.museumapi.util.MuseumDtoConverter;
import io.micrometer.common.util.StringUtils;
import jakarta.websocket.server.PathParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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
    public List<MuseumDto> getAllMuseums(@PathParam("filter") String filter){
        List<MuseumDto> museumDtos = new ArrayList<>();
        List<Museum> museums;
        if(StringUtils.isNotBlank(filter)) {
            museums = museumService.findByMuseumNameContains(filter);
        }
        else {
            museums = museumService.findAll();
        }
        for (Museum museum: museums) {
            museumDtos.add(MuseumDtoConverter.convert(museum));
        }
        return museumDtos;
    }
    @GetMapping("/museums/summary")
    public List<MuseumDto> getAllMuseumsDto(@PathParam("filter") String filter){
        List<MuseumDto> museumDtos = new ArrayList<>();
        museumDtos = museumService.findAllMuseumDto();
        return museumDtos;
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
    public List<MuseumDto> getMuseumById(@PathVariable int id) {
        List<MuseumDto> museumDtos = new ArrayList<>();
        Museum museum = museumService.findById(id);
        museumDtos.add(MuseumDtoConverter.convert(museum));
        return museumDtos;
    }
    @GetMapping("/museum/address/{id}")
    public ResponseEntity<MuseumDto> getMuseumAddressById(@PathVariable Integer id) {
        Museum museum = museumService.findById(id);

        if (museum == null) {
            return ResponseEntity.notFound().build();
        }

        MuseumDto museumDto = MuseumDtoConverter.convert(museum);

        return ResponseEntity.ok(museumDto);
    }
}
