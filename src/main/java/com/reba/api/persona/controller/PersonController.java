package com.reba.api.persona.controller;

import com.reba.api.persona.model.Person;
import com.reba.api.persona.dto.PersonDTO;
import com.reba.api.persona.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping("/persona/{id}")
    public ResponseEntity<Person> getPerson(@PathVariable Long id) {
        Person person = personService.getPerson(id);
        return new ResponseEntity<>(person,HttpStatus.OK);
    }

    @GetMapping("/personas")
    public ResponseEntity<List<Person>> getPeople() {
        List<Person> people = personService.getPeople();
        return new ResponseEntity<>(people, HttpStatus.OK);
    }

    @PostMapping(path = "/persona", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Person> createPerson(@RequestBody @Valid PersonDTO personDTO) {
        Person person = personService.createPerson(personDTO);
        return new ResponseEntity<Person>(person, HttpStatus.CREATED);
    }

    @PostMapping(path = "/personas/{id1}/padre/{id2}")
    public ResponseEntity<Person> createFatherPerson(@PathVariable Long id1, @PathVariable Long id2) {
        Person person = personService.updateFatherToPerson(id1, id2);
        return new ResponseEntity<Person>(person, HttpStatus.CREATED);
    }

}
