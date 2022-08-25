package com.reba.api.persona.model;

import lombok.Data;

import javax.persistence.*;

//Clase que representa la tabla tipo de documento

@Data
@Entity
@Table(name = "document_type")
public class DocumentType {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;
}
