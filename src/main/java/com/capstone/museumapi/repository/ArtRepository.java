package com.capstone.museumapi.repository;

import com.capstone.museumapi.model.Art;
import com.capstone.museumapi.model.Artist;
import com.capstone.museumapi.model.Painting;
import com.capstone.museumapi.model.Sculpture;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArtRepository extends CrudRepository<Art, Integer> {
    List<Art> findArtByNameContainingIgnoreCase(String art);
    List<Art> findArtByArtist(Artist artist);
}
