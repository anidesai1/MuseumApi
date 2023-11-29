package com.capstone.museumapi.service;

import com.capstone.museumapi.dto.MuseumDto;
import com.capstone.museumapi.model.Museum;
import com.capstone.museumapi.repository.MuseumRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
        return museumRepository.findByMuseumNameContainingIgnoreCase(filter);
    }

    @Override
    public Museum save(Museum m) {
        return museumRepository.save(m);
    }

    @Override
    public void deleteMuseum(Integer id) {
        museumRepository.deleteById(id);
    }

    @Override
    public Museum findById(int id) {
        Optional<Museum> museum = museumRepository.findById(id);
        return museum.orElseGet(() -> new Museum("Default Message: Nothing found"));
    }

    @Override
    public List<MuseumDto> findAllMuseumDto() {
        return museumRepository.findAllMuseumDto();
    }
}
