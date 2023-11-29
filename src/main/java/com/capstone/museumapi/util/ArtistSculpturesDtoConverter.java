package com.capstone.museumapi.util;

import com.capstone.museumapi.dto.ArtistSculptureDto;
import com.capstone.museumapi.model.Artist;

public class ArtistSculpturesDtoConverter {
    public static ArtistSculptureDto convert(Artist artist) {
        return new ArtistSculptureDto(artist.getId(), artist.getArtistName());
    }

    public static ArtistSculptureDto convertWithSculptures(Artist artist) {
        return new ArtistSculptureDto(artist.getId(),
                artist.getArtistName(),
                artist.getSculptures());
    }
}
