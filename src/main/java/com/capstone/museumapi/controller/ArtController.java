package com.capstone.museumapi.controller;

import com.capstone.museumapi.model.Art;
import com.capstone.museumapi.model.Artist;
import com.capstone.museumapi.service.ArtService;
import com.capstone.museumapi.service.ArtistService;
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
public class ArtController {
    ArtService artService;
    ArtistService artistService;

    public ArtController(ArtService artService, ArtistService artistService) {
        this.artService = artService;
        this.artistService = artistService;
    }

    @GetMapping("/art")
    public List<Art> getAllArts(@PathParam("filter") String filter){
        List<Art> art = Collections.emptyList();
        if(StringUtils.isNotBlank(filter)) {
            art = artService.findByArtNameContains(filter);
        }
        else {
            art = artService.findAll();
        }
        return art;
    }
    @PostMapping("/art")
    public Art createArt(@RequestBody Art art){
        return artService.save(art);
    }
    @DeleteMapping("/art/{id}")
    public ResponseEntity<String> deleteArt(@PathVariable Integer id) {
        artService.deleteArt(id);
        return new ResponseEntity<>("Art deleted successfully", HttpStatus.OK);
    }
    @GetMapping("/art/{id}")
    public Art getArt(@PathVariable Integer id) {
        return artService.findById(id);
    }
    @GetMapping("/paintingsByArtist/{artistId}")
    public List<Art> getPaintingsByArtist(@PathVariable("artistId") Integer artistId) {
        Artist artist = artistService.findArtistById(artistId).orElseThrow(() -> new RuntimeException("Artist not found with ID: " + artistId));
        return artService.findAllPaintingsByArtist(artist);
    }
}
