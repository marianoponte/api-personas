package com.reba.api.persona.model;

import com.reba.api.persona.utils.Constants;

public class Brother {

    public static String exist(Person persona1, Person persona2) {
        if (persona1.getFather() != null
                && persona2.getFather() != null
                && persona1.getFather().equals(persona2.getFather())) {
            return Constants.HERMANO;
        } else return null;
    }
}