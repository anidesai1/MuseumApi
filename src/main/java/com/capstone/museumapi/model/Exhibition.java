package com.capstone.museumapi.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Exhibition {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String exhibitionType;
    private String exhibitionName;
    private String startDate;
    private String endDate;

    @ManyToMany
    @JoinTable(
            name = "museum_exhibition",
            joinColumns = @JoinColumn(name = "exhibition_id"),
            inverseJoinColumns = @JoinColumn(name = "museum_id")
    )
    private Set<Museum> museums = new HashSet<>();
}
