package com.capstone.museumapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArtistDto {
    private MuseumDto museumDto;
    private Integer id;
    private String artistName;
    private String yearBorn;
    private String yearDown;
    private Integer numberOfWork;

    public ArtistDto(Integer id, String artistName, String yearBorn, String yearDown, Integer numberOfWork) {
        this.id = id;
        this.artistName = artistName;
        this.yearBorn = yearBorn;
        this.yearDown = yearDown;
        this.numberOfWork = numberOfWork;
    }
}
