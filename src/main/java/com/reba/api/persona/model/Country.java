package com.reba.api.persona.model;

import lombok.*;

import javax.persistence.*;

//Clase que representa la tabla pais

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "countries")
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "code")
    private String code;

    @Column(name = "name")
    private String name;

    public Country(String code, String name) {
        this.code = code;
        this.name = name;
    }
}
