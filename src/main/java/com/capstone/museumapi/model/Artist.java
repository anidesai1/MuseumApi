package com.capstone.museumapi.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
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
}
