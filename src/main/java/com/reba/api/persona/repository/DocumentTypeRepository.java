package com.reba.api.persona.repository;

import com.reba.api.persona.model.DocumentType;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface DocumentTypeRepository extends CrudRepository<DocumentType, Long> {

    Optional<DocumentType> findById(Long id);

}
