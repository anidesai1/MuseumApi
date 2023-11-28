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
@DiscriminatorValue("Sculpture")
@Getter
@Setter
public class Sculpture extends Art{
    private Integer numberOfSculpturesByGivenArtist;
    @ManyToOne
    @JsonBackReference(value = "sculptures-managed")
    private Museum museumSculptures;
}
