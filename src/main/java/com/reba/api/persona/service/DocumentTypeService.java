package com.reba.api.persona.service;

import com.reba.api.persona.model.DocumentType;
import com.reba.api.persona.repository.DocumentTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DocumentTypeService {

    @Autowired
    private DocumentTypeRepository documentTypeRepository;

    public Optional<DocumentType> findById(Long id) {
        return documentTypeRepository.findById(id);
    }

}
