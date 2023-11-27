package com.capstone.museumapi.service;

import com.capstone.museumapi.model.Artist;
import com.capstone.museumapi.model.Museum;
import com.capstone.museumapi.repository.ArtistRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
        return artistRepository.save(a);
    }

    @Override
    public void deleteArtist(Integer id) {
        artistRepository.deleteById(id);
    }

    @Override
    public Artist findById(int id) {
        Optional<Artist> artist = artistRepository.findById(id);
        return artist.orElseGet(() -> new Artist("Default Message: Nothing found"));
    }
}
