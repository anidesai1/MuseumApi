package com.capstone.museumapi.service;

import com.capstone.museumapi.model.Museum;
import com.capstone.museumapi.repository.MuseumRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class MuseumServiceImpl implements MuseumService{
    MuseumRepository museumRepository;
    @Override
    public List<Museum> findAll() {
        List<Museum> museums = new ArrayList<>();
        Iterable<Museum> museumsIts = museumRepository.findAll();
        museumsIts.forEach(museums::add);
        return museums;
    }

    @Override
    public List<Museum> findByMuseumNameContains(String filter) {
        return null;
    }

    @Override
    public Museum save(Museum m) {
        return null;
    }

    @Override
    public void deleteMuseum(Integer id) {

    }

    @Override
    public Museum findById(int id) {
        return null;
    }
}
