package com.reba.api.persona.service;

import com.reba.api.persona.model.*;
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
         if (person1.isBrother(person2)) {
             return Constants.HERMANO;
         }
         if (person1.isCousin(person2)) {
            return Constants.PRIMO;
         }
         if (person1.isUncle(person2) || person2.isUncle(person1)) {
             return Constants.TIO;
         }
         return Constants.NO_RELATIONSHIP;
    }

}