package com.capstone.museumapi.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
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

    @ManyToOne
    @JsonBackReference(value = "paintings-managed")
    private Museum museumPaintings;

    @ManyToOne
    @JsonBackReference(value = "painting-managed")
    private Artist artistPainting;
}
