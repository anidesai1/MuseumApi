package com.capstone.museumapi.service;

import com.capstone.museumapi.model.Art;
import com.capstone.museumapi.model.Artist;
import com.capstone.museumapi.model.Painting;
import com.capstone.museumapi.model.Sculpture;

import java.util.List;
import java.util.Optional;

public interface ArtService {
    List<Art> findAll();
    List<Art> findByArtNameContains(String filter);
    Art save(Art a);
    void deleteArt(Integer id);
    Art findById(int id);
    List<Art> findAllPaintingsByArtist(Artist artist);
    List<Painting> getAllPaintings();
    List<Sculpture> getAllSculptures();
}
