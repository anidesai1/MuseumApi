package com.capstone.museumapi.service;

import com.capstone.museumapi.model.Artist;
import java.util.List;

public interface ArtistService {
    List<Artist> findAll();
    List<Artist> findByArtistNameContains(String filter);
    Artist save(Artist a);
    void deleteArtist(Integer id);
    Artist findById(int id);
}
