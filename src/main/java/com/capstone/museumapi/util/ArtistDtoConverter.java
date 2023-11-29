package com.capstone.museumapi.util;

import com.capstone.museumapi.dto.ArtistPaintingsDto;
import com.capstone.museumapi.model.Artist;

public class ArtistDtoConverter {
    public static ArtistPaintingsDto convert(Artist artist) {
        return new ArtistPaintingsDto(
                artist.getId(),
                artist.getArtistName());
    }
    public static ArtistPaintingsDto convertWithPaintings(Artist artist) {
        return new ArtistPaintingsDto(artist.getId(),
                artist.getArtistName(),
                artist.getPaintings());
    }
}
