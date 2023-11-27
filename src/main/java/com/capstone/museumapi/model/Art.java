package com.capstone.museumapi.model;

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

    @ManyToOne
    private Artist artist;
}
