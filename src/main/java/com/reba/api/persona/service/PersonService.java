package com.reba.api.persona.service;

import com.reba.api.persona.exception.*;
import com.reba.api.persona.model.Country;
import com.reba.api.persona.model.DocumentType;
import com.reba.api.persona.model.Person;
import com.reba.api.persona.dto.PersonDTO;
import com.reba.api.persona.repository.PersonRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.commons.lang3.StringUtils;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private DocumentTypeService documentTypeService;

    @Autowired
    private CountryService countryService;

    @Autowired
    private ModelMapper modelMapper;

    //Obtener todas las personas
    public List<Person> getPeople() {
        return (List<Person>) personRepository.findAll();
    }

    //Crear persona
    public Person createPerson(PersonDTO personDTO) {
        //Obtengo los objetos correspondientes segun los datos ingresados
        DocumentType documentType = getDocumentType(personDTO.getDocumentType());
        Country country = getCountry(personDTO.getCountry());

        validateContactData(personDTO);

        isOlder(personDTO.getBirthDate());

        isRepeatedPerson(documentType, personDTO.getDocumentNumber(), country);

        Person personRequest = personDTOToPerson(personDTO, documentType, country);

        return personRepository.save(personRequest);
    }

    //Metodo para mapeo de entidad a dto
    public Person personDTOToPerson(PersonDTO personDTO, DocumentType documentType, Country country) {
        Person person = modelMapper.map(personDTO, Person.class);
        person.setDocumentType(documentType);
        person.setCountry(country);
        return person;
    }

    //Metodo para obtener el tipo de documento por id
    public DocumentType getDocumentType(Long documentTypeId) {
        Optional<DocumentType> documentTypeOpt = documentTypeService.findById(documentTypeId);
        DocumentType documentType = documentTypeOpt.orElseThrow(() -> new DocumentTypeNotFoundException(documentTypeId));
        return documentType;
    }

    //Metodo para obtener el pais por el nombre
    public Country getCountry(String countryName) {
        Optional<Country> countryOpt = countryService.findByName(countryName);
        Country country = countryOpt.orElseThrow(() -> new CountryNotFoundException(countryName));
        return country;
    }

    public void validateContactData(PersonDTO personDTO) {
        if (StringUtils.isBlank(personDTO.getContactNumber()) && StringUtils.isBlank(personDTO.getEmail())) {
            throw new DataContactPersonMissedException();
        }
    }

    //Validar persona repetida por tipo documento, numero documento y pais
    public void isRepeatedPerson(DocumentType documentType, String documentNumber, Country country) {
        Optional<Person> foundPerson = personRepository.findByDocumentTypeAndDocumentNumberAndCountry(documentType, documentNumber, country);

        if (foundPerson.isPresent()) {
            throw new PersonDuplicatedException();
        }
    }

    //Valido que sea mayor de 18 años
    public void isOlder(String birthDate) {
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        Period periodo;
        try {
            LocalDate birthDateFormatted = LocalDate.parse(birthDate, fmt);
            LocalDate now = LocalDate.now();
            periodo = Period.between(birthDateFormatted, now);
        }
        catch (Exception e) {
            throw new BirthDateFormatException();
        }

        if (periodo.getYears() < 18) {
            throw new PersonIsNotOlderException();
        }
    }

    //Actualizo el padre a la persona
    public Person updateFatherToPerson(Long idSon, Long idFather) {
        if (idSon != null && idFather != null && idSon.equals(idFather))
        {
            throw new BusinessException("Los id de las personas son el mismo");
        }
        Person personSon = getPersonExistById(idSon);
        Person personFather = getPersonExistById(idFather);

        personSon.setFather(personFather);

        personRepository.save(personSon);

        return personSon;
    }

    //Obtiene la persona por id y sino tira exception
    public Person getPersonExistById(Long id) {
        Optional<Person> personSonOpt = personRepository.findById(id);
        return personSonOpt.orElseThrow(() -> new PersonNotFoundException());
    }

    //Obtiene cantidad de personas dadas de alta
    public Long getCountPeople() {
        return personRepository.count();
    }

    //Obtiene cantidad de personas dadas de alta por pais
    public Long getCountPeopleByCountry(Country country) {
        return personRepository.countByCountry(country);
    }
}