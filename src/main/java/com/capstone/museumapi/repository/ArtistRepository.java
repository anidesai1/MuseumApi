package com.capstone.museumapi.repository;

import com.capstone.museumapi.model.Artist;
import org.springframework.boot.autoconfigure.context.LifecycleAutoConfiguration;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArtistRepository extends CrudRepository<Artist, Integer> {
    List<Artist> findByArtistNameContains(String filter);
    List<Artist> findArtistByArtsContainingIgnoreCase(String art);
    List<Artist> findArtistById(Integer id);
    List<Artist> findArtistByMuseum();
    List<Artist> findArtistByMuseumContainsIgnoreCase(String museum);
    List<Artist> findArtistByYearBornContainingIgnoreCase(String yearBorn);
    List<Artist> findArtistByYearDownContainingIgnoreCase(String yearDown);
    List<Artist> findArtistByNumberOfWorkByArtist(String artist);
    List<Artist> findArtistByNumberOfWorkByArtistGreaterThanOrderByArtistName();
}
