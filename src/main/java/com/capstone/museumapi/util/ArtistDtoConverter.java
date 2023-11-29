package com.capstone.museumapi.util;

import com.capstone.museumapi.dto.ArtistDto;
import com.capstone.museumapi.model.Artist;

public class ArtistDtoConverter {
    public static ArtistDto convert(Artist artist) {
        return new ArtistDto(
                artist.getId(),
                artist.getArtistName());
    }
    public static ArtistDto convertWithPaintings(Artist artist) {
        return new ArtistDto(artist.getId(),
                artist.getArtistName(),
                artist.getPaintings());
    }
}
