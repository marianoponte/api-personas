package com.reba.api.persona.service;

import com.reba.api.persona.model.Brother;
import com.reba.api.persona.model.Cousin;
import com.reba.api.persona.model.Person;
import com.reba.api.persona.model.Relation;
import com.reba.api.persona.repository.PersonRepository;
import com.reba.api.persona.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class RelationshipService {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private PersonService personService;

    public String getRelationship(Long idPersona1, Long idPersona2) {
        Person person1 = personService.getPersonExistById(idPersona1);
        Person person2 = personService.getPersonExistById(idPersona2);

        List<Class<?>> classes = Arrays.<Class<?>>asList(Brother.class, Cousin.class);

  /* classes.stream().forEach(x -> x.);
        List<Relation> relations = new ArrayList<>();
        relations.add(Brother.class);
        //relations.add(Brother.class);
       
   */

        //relations.forEach(x -> Brother.exist());
        //relations.forEach(x ->  (person1, person2));

        /*
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
         */
        return Constants.NO_RELATIONSHIP;
    }
}