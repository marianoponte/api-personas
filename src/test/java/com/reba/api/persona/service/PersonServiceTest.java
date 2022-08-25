package com.reba.api.persona.service;

import com.reba.api.persona.model.Country;
import com.reba.api.persona.model.DocumentType;
import com.reba.api.persona.model.Person;
import com.reba.api.persona.repository.PersonRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.mockito.BDDMockito.given;
import static org.assertj.core.api.Assertions.assertThat;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PersonServiceTest {

    @Mock
    private PersonRepository personRepository;

    @InjectMocks
    private PersonService personService;

    private Country country = new Country("AR", "Argentina");
    private DocumentType documentType = new DocumentType("DNI");
    private Person person1 = new Person(
            documentType,
            "12345",
            country,
            "Mariano",
            "Ponte",
            "09-09-1996",
            "Argentino",
            "mariano@hotmail.com",
            "12345");

    private Person person2 = new Person(
            documentType,
            "54321",
            country,
            "Angel",
            "Ponte",
            "10-09-1987",
            "Argentino",
            "angel@hotmail.com",
            "54321");

    private Person person3 = new Person(
            documentType,
            "34567",
            country,
            "Luis",
            "Ponte",
            "20-05-2003",
            "Argentino",
            "Luis@hotmail.com",
            "34567");

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void canGetPeople() {
        personService.getPeople();

        verify(personRepository).findAll();
    }

    @Test
    void createPerson() {
    }

    @Test
    void personDTOToPerson() {
    }

    @Test
    void getDocumentType() {
    }

    @Test
    void getCountry() {
    }

    @Test
    void validateContactData() {
    }

    @Test
    void isRepeatedPerson() {
    }

    @Test
    void isOlder() {
    }

    @Test
    void updateFatherToPerson() {
    }

    @Test
    void CanGetPersonExistById() {
        //given
        Long idPersona = Long.valueOf(1);
        given(personRepository.findById(idPersona)).willReturn(Optional.of(person1));

        Person personResult = personService.getPersonExistById(idPersona);

        assertThat(personResult).isNotNull();
        verify(personRepository, times(1)).findById(idPersona);
    }

    @Test
    void getCountPeople() {
        given(personRepository.count()).willReturn((long) List.of(person1,person2,person3).size());

        Long peopleCount = personService.getCountPeople();

        assertThat(peopleCount).isEqualTo(3);
        verify(personRepository, times(1)).count();
    }

    @Test
    void getCountPeopleByCountry() {
    }
}