package com.capstone.museumapi.util;

import com.capstone.museumapi.dto.MuseumDto;
import com.capstone.museumapi.model.Museum;

public class MuseumDtoConverter {
    public static MuseumDto convert(Museum museum) {
        return new MuseumDto(museum.getId(), museum.getMuseumName(), museum.getLocation(), museum.getCurator(), museum.getTotalNumberOfArtWork(), museum.getAddress(), museum.getArtists());

    }
    public static MuseumDto convertWithLessDetails(Museum museum){
        return new MuseumDto(museum.getId(), museum.getMuseumName(), museum.getCurator(), museum.getAddress());
    }
}
