package com.capstone.museumapi.dto;

import com.capstone.museumapi.model.Sculpture;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ArtistSculptureDto {
    private Integer id;
    private String artistName;
    private MuseumDto museum;
    private List<Sculpture> sculptures;

    public ArtistSculptureDto(Integer id, String artistName) {
        this.id = id;
        this.artistName = artistName;
    }

    public ArtistSculptureDto(Integer id, String artistName, List<Sculpture> sculptures) {
        this.id = id;
        this.artistName = artistName;
        this.sculptures = sculptures;
    }
}
