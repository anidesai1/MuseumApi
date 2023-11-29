package com.capstone.museumapi.repository;

import com.capstone.museumapi.dto.MuseumDto;
import com.capstone.museumapi.model.Exhibition;
import com.capstone.museumapi.model.Museum;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MuseumRepository extends CrudRepository <Museum, Integer>{
    List<Museum> findByMuseumNameContainingIgnoreCase(String filter);

    @Query("select new com.capstone.museumapi.dto.MuseumDto(m.id, m.museumName, m.curator, m.address) from Museum m")
    List<MuseumDto> findAllMuseumDto();
}
