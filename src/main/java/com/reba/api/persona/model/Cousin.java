package com.reba.api.persona.model;

import com.reba.api.persona.utils.Constants;

public class Cousin {

    public static String exist(Person persona1, Person persona2) {
        if (Brother.exist(persona1.getFather(), persona2.getFather()) != null) {
            return Constants.PRIMO;
        } else return null;
    }
}

