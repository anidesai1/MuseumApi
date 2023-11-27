package com.capstone.museumapi.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

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

    @JsonManagedReference
    @OneToMany(mappedBy = "museum")
    private List<Artist> artists;

}
