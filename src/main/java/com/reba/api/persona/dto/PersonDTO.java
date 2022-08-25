package com.reba.api.persona.dto;

import lombok.*;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PersonDTO {

    private Long id;

    @NotNull
    private Long documentType;

    @NotNull
    private String documentNumber;

    @NotNull
    private String country;

    @NotNull
    private String name;

    @NotNull
    private String lastName;

    @NotNull
    private String birthDate;

    private String nacionality;

    private String contactNumber;

    private String email;

    private PersonDTO father;
}