package com.capstone.museumapi.repository;

import com.capstone.museumapi.model.Artist;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ArtistRepository extends CrudRepository<Artist, Integer> {
    List<Artist> findByArtistNameContains(String filter);
    Optional<Artist> findArtistByNumberOfWork(int n);

}
