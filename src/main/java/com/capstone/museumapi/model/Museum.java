package com.capstone.museumapi.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Museum {
    @Getter
    @Id
    @GeneratedValue
    private Integer id;
    private String museumName;
    private String location;
    private String curator;
    private Integer totalNumberOfArtWork;

    @OneToOne(cascade = CascadeType.ALL)
    private MuseumAddress address;

    @JsonManagedReference(value = "artists-managed")
    @OneToMany(mappedBy = "museum")
    private List<Artist> artists;

    @JsonManagedReference(value = "paintings-managed")
    @OneToMany(mappedBy = "museumPaintings")
    private List<Painting> paintings;

    @JsonManagedReference(value = "sculptures-managed")
    @OneToMany(mappedBy = "museumSculptures")
    private List<Sculpture> sculptures;

    @ManyToMany(mappedBy = "museums")
    private Set<Exhibition> exhibitions = new HashSet<>();

    public Museum(String s) {
    }
}
