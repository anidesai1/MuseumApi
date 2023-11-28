package com.capstone.museumapi.service;

import com.capstone.museumapi.model.Art;
import com.capstone.museumapi.model.Artist;
import com.capstone.museumapi.model.Painting;
import com.capstone.museumapi.model.Sculpture;
import com.capstone.museumapi.repository.ArtRepository;
import com.capstone.museumapi.repository.ArtistRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
@AllArgsConstructor
public class ArtServiceImpl implements ArtService{
    ArtRepository artRepository;
    ArtistRepository artistRepository;
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
        return artRepository.save(a);
    }

    @Override
    public void deleteArt(Integer id) {
        artRepository.deleteById(id);
    }

    @Override
    public Art findById(int id) {
        Optional<Art> art = artRepository.findById(id);
        return art.orElseGet(() -> new Art("Default Message: Nothing found"));
    }
    @Override
    public List<Art> findAllPaintingsByArtist(Artist artist) {
        return artRepository.findArtByArtist(artist);
    }
    @Override
    public List<Painting> getAllPaintings() {
        List<Art> allArtworks = (List<Art>) artRepository.findAll();

        return allArtworks.stream()
                .filter(Painting.class::isInstance)
                .map(Painting.class::cast)
                .collect(Collectors.toList());
    }
    @Override
    public List<Sculpture> getAllSculptures() {
        List<Art> allArtworks = (List<Art>) artRepository.findAll();

        return allArtworks.stream()
                .filter(Sculpture.class::isInstance)
                .map(Sculpture.class::cast)
                .collect(Collectors.toList());
    }
}
