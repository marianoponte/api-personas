package com.reba.api.persona.service;

import com.reba.api.persona.model.Person;
import com.reba.api.persona.repository.PersonRepository;
import com.reba.api.persona.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RelationshipService {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private PersonService personService;

    public String getRelationship(Long idPersona1, Long idPersona2) {
        Person person1 = personService.getPersonExistById(idPersona1);
        Person person2 = personService.getPersonExistById(idPersona2);

         if (isBrother(person1,person2)) {
             return Constants.HERMANO;
         }
         if (isCousin(person1,person2)) {
            return Constants.PRIMO;
         }
         if (isUncle(person1,person2)) {
             return Constants.TIO;
         }
         return Constants.NO_RELATIONSHIP;
    }

    private Boolean isBrother(Person person1, Person person2) {
        Long person1Father = person1.getFather();
        Long person2Father = person2.getFather();

        if (person1Father != null && person2Father != null && person1Father.equals(person2Father)) {
            return true;
        } else
            return false;
    }

    private Boolean isCousin(Person person1, Person person2) {
        Person person1father = personService.getPersonExistById(person1.getFather());
        Person person2father = personService.getPersonExistById(person2.getFather());
        if (isBrother(person1father, person2father)) {
            return true;
        } else return false;
    }

    private Boolean isUncle(Person person1, Person person2) {
        Person person1father = personService.getPersonExistById(person1.getFather());
        Person person2father = personService.getPersonExistById(person2.getFather());
        if (isBrother(person1father, person2) || isBrother(person2father, person2)) {
            return true;
        } else return false;

    }
}