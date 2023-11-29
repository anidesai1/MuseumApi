package com.capstone.museumapi.service;

import com.capstone.museumapi.dto.MuseumDto;
import com.capstone.museumapi.model.Museum;
import java.util.List;

public interface MuseumService {
    List<Museum> findAll();
    List<Museum> findByMuseumNameContains(String filter);
    Museum save(Museum m);
    void deleteMuseum(Integer id);
    Museum findById(int id);
    List<MuseumDto> findAllMuseumDto();
}
