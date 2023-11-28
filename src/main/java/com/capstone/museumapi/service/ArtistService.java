package com.capstone.museumapi.service;

import com.capstone.museumapi.model.Artist;
import java.util.List;
import java.util.Optional;

public interface ArtistService {
    List<Artist> findAll();
    List<Artist> findByArtistNameContains(String filter);
    Artist findByNumberOfWork(int n);
    Artist save(Artist a);
    void deleteArtist(Integer id);
    Artist findById(int id);
    Optional<Artist> findArtistById(int id);

}
