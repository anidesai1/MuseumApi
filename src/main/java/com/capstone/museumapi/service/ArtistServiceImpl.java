package com.capstone.museumapi.service;

import com.capstone.museumapi.model.Artist;
import com.capstone.museumapi.model.Museum;
import com.capstone.museumapi.repository.ArtistRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class ArtistServiceImpl implements ArtistService{
    ArtistRepository artistRepository;
    @Override
    public List<Artist> findAll() {
        List<Artist> artists = new ArrayList<>();
        Iterable<Artist> artistsIts = artistRepository.findAll();
        artistsIts.forEach(artists::add);
        return artists;
    }

    @Override
    public List<Artist> findByArtistNameContains(String filter) {
        return artistRepository.findByArtistNameContains(filter);
    }

    @Override
    public Artist save(Artist a) {
        return null;
    }

    @Override
    public void deleteArtist(Integer id) {

    }

    @Override
    public Artist findById(int id) {
        return null;
    }
}
