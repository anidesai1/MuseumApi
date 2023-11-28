package com.capstone.museumapi.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@NoArgsConstructor
@DiscriminatorValue("Sculpture")
@Getter
@Setter
public class Sculpture extends Art{
    private Integer numberOfSculpturesByGivenArtist;
    private String sculptureName;

    @ManyToOne
    @JsonBackReference(value = "sculptures-managed")
    private Museum museumSculptures;

    @ManyToOne
    @JsonBackReference(value = "sculptures-managed")
    private Artist artistSculpture;
}
