package com.capstone.museumapi.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "Art_Type")
@NoArgsConstructor
@Getter
@Setter
public class Art {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String artistName;
    private String yearCompleted;
    private String medium;
    private String backstory;
    private String location;

    @ManyToOne
    @JsonBackReference(value = "arts-managed")
    private Artist artist;

    public Art(String a) {
    }
}
