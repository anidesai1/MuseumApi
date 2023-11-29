package com.capstone.museumapi.dto;

import com.capstone.museumapi.model.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.List;

@Data
@AllArgsConstructor
public class MuseumDto {
    private Integer id;
    private String museumName;
    private String location;
    private String curator;
    private Integer totalNumberOfArtWork;
    private MuseumAddress address;

    @JsonIgnore
    private List<Artist> artists;

    public MuseumDto () {

    }

    public MuseumDto(Integer id, String museumName, String curator, MuseumAddress address) {
        this.id = id;
        this.museumName = museumName;
        this.curator = curator;
        this.address = address;
    }

}
