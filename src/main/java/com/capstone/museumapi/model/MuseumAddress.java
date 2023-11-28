package com.capstone.museumapi.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
@Entity
@Getter
@Setter
public class MuseumAddress {
        @Id
        @GeneratedValue
        private Integer id;
        private String lineOne;
        private String lineTwo;
        private String state;
        private String postCode;
        private String country;
}
