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
public class Museum {
    @Getter
    @Id
    @GeneratedValue
    private Integer id;
    private String museumName;
    private String location;
    private String curator;
}
