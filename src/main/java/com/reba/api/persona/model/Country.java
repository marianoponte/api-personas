package com.reba.api.persona.model;

import lombok.Data;

import javax.persistence.*;

//Clase que representa la tabla pais

@Data
@Entity
@Table(name = "countries")
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "code")
    private String code;

    @Column(name = "name")
    private String name;
}
