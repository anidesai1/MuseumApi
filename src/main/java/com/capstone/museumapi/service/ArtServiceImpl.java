package com.capstone.museumapi.service;

import com.capstone.museumapi.model.Art;
import com.capstone.museumapi.model.Artist;
import com.capstone.museumapi.repository.ArtRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
@Slf4j
@AllArgsConstructor
public class ArtServiceImpl implements ArtService{
    ArtRepository artRepository;
    @Override
    public List<Art> findAll() {
        List<Art> art = new ArrayList<>();
        Iterable<Art> artIts = artRepository.findAll();
        artIts.forEach(art::add);
        return art;
    }
    @Override
    public List<Art> findByArtNameContains(String filter) {
        return artRepository.findArtByNameContainingIgnoreCase(filter);
    }

    @Override
    public Art save(Art a) {
        return null;
    }

    @Override
    public void deleteArt(Integer id) {

    }

    @Override
    public Art findById(int id) {
        return null;
    }
}
