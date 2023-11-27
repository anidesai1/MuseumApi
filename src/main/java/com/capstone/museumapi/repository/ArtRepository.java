package com.capstone.museumapi.repository;

import com.capstone.museumapi.model.Art;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArtRepository extends CrudRepository<Art, Integer> {
    List<Art> findArtByArtistContainingIgnoreCase(String artist);
    List<Art> findArtByArtistNameIgnoreCase(String artist);
    List<Art> findArtById(Integer id);
    List<Art> findArtByMediumContainsIgnoreCase(String medium);
    List<Art> findArtByNameContainingIgnoreCase(String name);
    List<Art> findArtByYearCompletedOrderByYearCompleted();
}
