package com.capstone.museumapi.service;

import com.capstone.museumapi.model.Art;

import java.util.List;

public interface ArtService {
    List<Art> findAll();
    List<Art> findByArtNameContains(String filter);
    Art save(Art a);
    void deleteArt(Integer id);
    Art findById(int id);
}
