package com.capstone.museumapi.dto;

import com.capstone.museumapi.model.Painting;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor @NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ArtistPaintingsDto {
    private Integer id;
    private String artistName;
    private MuseumDto museum;
    private List<Painting> paintings;

    public ArtistPaintingsDto(Integer id, String artistName) {
        this.id = id;
        this.artistName = artistName;
    }
    public ArtistPaintingsDto(Integer id, String artistName, List<Painting> paintings) {
        this.id = id;
        this.artistName = artistName;
        this.paintings = paintings;
    }
}
