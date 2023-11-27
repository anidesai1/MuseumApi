package com.capstone.museumapi.repository;

import com.capstone.museumapi.model.Museum;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MuseumRepository extends CrudRepository<Museum, Integer> {
    List<Museum> findByMuseumNameContainingIgnoreCase(String filter);
    List<Museum> findMuseumByArtists();
    List<Museum> findMuseumByCurator();
    List<Museum> findMuseumByArtistsContainingIgnoreCase(String artist);
    List<Museum> findMuseumByCuratorContainingIgnoreCase(String curator);
    List<Museum> findMuseumByLocation();
    List<Museum> findMuseumByLocationContaining(String location);
    List<Museum> findMuseumById(Integer id);
    List<Museum> findMuseumByTotalNumberOfArtWork();
}
