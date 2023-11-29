package com.capstone.museumapi.util;

import com.capstone.museumapi.dto.ArtistDto;
import com.capstone.museumapi.model.Artist;

public class ArtistDtoConverter {
    public static ArtistDto convert(Artist artist) {
        return new ArtistDto(MuseumDtoConverter.convertWithoutArtists(artist.getMuseum()),
                artist.getId(),
                artist.getArtistName(),
                artist.getYearBorn(),
                artist.getYearDown(),
                artist.getTotalPaintings());
    }
    public static ArtistDto convertWithoutMuseum(Artist artist) {
        return new ArtistDto(artist.getId(),
                artist.getArtistName(),
                artist.getYearBorn(),
                artist.getYearDown(),
                artist.getTotalPaintings());
    }
}
