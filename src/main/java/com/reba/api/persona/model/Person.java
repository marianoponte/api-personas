package com.reba.api.persona.model;

import lombok.*;

import javax.persistence.*;

//Clase que representa la tabla de personas

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "people")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

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

    @Column(name = "nationality")
    private String nationality;

    @Column(name = "email")
    private String email;

    @Column(name = "contact_number")
    private String contactNumber;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "id_father")
    private Person father;

    public Person(DocumentType documentType, String documentNumber, Country country, String name, String lastName, String birthDate, String nationality, String email, String contactNumber) {
        this.documentType = documentType;
        this.documentNumber = documentNumber;
        this.country = country;
        this.name = name;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.nationality = nationality;
        this.email = email;
        this.contactNumber = contactNumber;
    }

    public Boolean isBrother(Person persona2) {
        return (!this.getId().equals(persona2.getId())
                && this.getFather() != null
                && persona2.getFather() != null
                && this.getFather().equals(persona2.getFather()));
    }

    public Boolean isCousin(Person persona2) {
        if (this.getFather() != null && persona2.getFather() != null && this.getFather().isBrother(persona2.getFather())) {
            return true;
        } else return false;
    }

    public Boolean isUncle(Person person2) {
        if (this.getFather() != null && this.getFather().isBrother(person2)) {
            return true;
        } else return false;
    }
}
