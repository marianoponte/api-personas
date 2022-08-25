package com.reba.api.persona.controller;

import com.reba.api.persona.service.RelationshipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RelationshipController {

    @Autowired
    private RelationshipService relationshipService;

    @GetMapping(path = "relaciones/{id1}/{id2}")
    public String getRelationship(@PathVariable Long id1, @PathVariable Long id2) throws Exception {
        return relationshipService.getRelationship(id1,id2);
    }
}
