package com.capstone.museumapi.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
@Entity
public class Artist {
    @Getter
    @Id
    @GeneratedValue
    private Integer id;
    private String artistName;
    private String yearBorn;
    private String yearDown;
    private Integer numberOfWork;
    @Transient
    private int totalPaintings;

    @ManyToOne(cascade = CascadeType.MERGE)
    //@JoinColumn(name = "museum_id")
    @JsonBackReference(value = "artists-managed")
    private Museum museum;

    @JsonManagedReference(value = "arts-managed")
    @OneToMany(mappedBy = "artist")
    private List<Art> arts;

    @JsonManagedReference(value = "sculpture-managed")
    @OneToMany(mappedBy = "artistSculpture")
    private List<Sculpture> sculptures;

    @JsonManagedReference(value = "painting-managed")
    @OneToMany(mappedBy = "artistPainting")
    private List<Painting> paintings;

    public Artist(String a) {
    }
}
