package com.reba.api.persona.model;

import lombok.Data;

import javax.persistence.*;

//Clase que representa la tabla de personas

@Data
@Entity
@Table(name = "people")
public class Person extends BaseEntity {

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "id_document_type")
    private DocumentType documentType;

    @Column(name = "document_number")
    private String documentNumber;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "id_countries")
    private Country country;

    @Column(name = "name")
    private String name;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "birth_date")
    private String birthDate;

    @Column(name = "nacionality")
    private String nacionality;

    @Column(name = "email")
    private String email;

    @Column(name = "contact_number")
    private String contactNumber;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "id_father")
    private Person father;

}
