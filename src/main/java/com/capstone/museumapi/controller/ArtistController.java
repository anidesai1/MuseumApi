package com.capstone.museumapi.controller;

import com.capstone.museumapi.dto.ArtistDto;
import com.capstone.museumapi.model.Artist;
import com.capstone.museumapi.service.ArtistService;
import com.capstone.museumapi.util.ArtistDtoConverter;
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
public class ArtistController {
    ArtistService artistService;

    public ArtistController(ArtistService artistService) {
        this.artistService = artistService;
    }
    @GetMapping("/artists")
    public List<Artist> getAllArtists(@PathParam("filter") String filter){
        List<Artist> artists = Collections.emptyList();
        if(StringUtils.isNotBlank(filter)) {
            artists = artistService.findByArtistNameContains(filter);
        }
        else {
            artists = artistService.findAll();
        }
        return artists;
    }
    @PostMapping("/artist")
    public Artist createArtist(@RequestBody Artist artist){
        return artistService.save(artist);
    }
    @DeleteMapping("/artist/{id}")
    public ResponseEntity<String> deleteArtist(@PathVariable Integer id) {
        artistService.deleteArtist(id);
        return new ResponseEntity<>("Artist deleted successfully", HttpStatus.OK);
    }
    @GetMapping("/artist/{id}")
    public Artist getArtist(@PathVariable int id) {
        return artistService.findById(id);
    }
    @GetMapping("/artists/paintings/{id}")
    public List<ArtistDto> getAllPaintings(@PathVariable int id){
        List<ArtistDto> artistDtos = Collections.emptyList();
        Artist artists = artistService.findById(id);
        artistDtos.add(ArtistDtoConverter.convertWithPaintings(artists));
        return artistDtos;
    }
}
