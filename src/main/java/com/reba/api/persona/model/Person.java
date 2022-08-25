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

    public Boolean isBrother(Person persona2) {
        return (!this.getId().equals(persona2.getId())
                && this.getFather() != null
                && persona2.getFather() != null
                && this.getFather().equals(persona2.getFather()));
    }

    public Boolean isCousin(Person persona2) {
        if (this.getFather() != null && this.getFather().isBrother(persona2.getFather())) {
            return true;
        } else return false;
    }

    public Boolean isUncle(Person person2) {
        if (this.getFather() != null && this.getFather().isBrother(person2)) {
            return true;
        } else return false;
    }
}
