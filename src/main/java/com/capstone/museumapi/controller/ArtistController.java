package com.capstone.museumapi.controller;

import com.capstone.museumapi.model.Artist;
import com.capstone.museumapi.service.ArtistService;
import io.micrometer.common.util.StringUtils;
import jakarta.websocket.server.PathParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
