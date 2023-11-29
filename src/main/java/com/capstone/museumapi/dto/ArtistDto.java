package com.capstone.museumapi.dto;

import com.capstone.museumapi.model.Painting;
import com.capstone.museumapi.model.Sculpture;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor @NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true) //todo check
public class ArtistDto {
    private Integer id;
    private String artistName;
    private MuseumDto museum;
    private List<Painting> paintings;
    private List<Sculpture> sculptures;
    private String yearBorn;
    private String yearDown;
    private Integer numberOfWork;

    public ArtistDto(Integer id, String artistName) {
        this.id = id;
        this.artistName = artistName;
    }
//    public ArtistDto(Integer id, String artistName, List<Painting> paintings) {
//        this.id = id;
//        this.artistName = artistName;
//        this.paintings = paintings;
//    }
}
