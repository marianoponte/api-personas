package com.reba.api.persona.repository;

import com.reba.api.persona.model.Country;
import com.reba.api.persona.model.DocumentType;
import com.reba.api.persona.model.Person;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface PersonRepository extends CrudRepository<Person, Long> {

    Optional<Person> findById(Long id);

    Optional<Person> findByDocumentTypeAndDocumentNumberAndCountry(DocumentType documentType, String documentNumber, Country country);
}
