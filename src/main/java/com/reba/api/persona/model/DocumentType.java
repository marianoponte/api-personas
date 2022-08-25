package com.reba.api.persona.model;

import lombok.*;

import javax.persistence.*;

//Clase que representa la tabla tipo de documento

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "document_type")
public class DocumentType {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    public DocumentType(String name) {
        this.name = name;
    }
}
