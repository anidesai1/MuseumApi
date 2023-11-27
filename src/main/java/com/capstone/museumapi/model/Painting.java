package com.capstone.museumapi.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@DiscriminatorValue("Painting")
@Getter
@Setter
public class Painting extends Art {
    private String style;
    private Integer numberOfPaintingsByGivenArtist;
}
