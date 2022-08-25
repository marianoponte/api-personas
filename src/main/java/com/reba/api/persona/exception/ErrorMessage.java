package com.reba.api.persona.exception;

public class ErrorMessage {

    public static final String DATA_CONTACT_PERSON_MISSED = "Se debe completar un dato de contacto: 'contactNumber' o 'email'";
    public static final String FIELD_CANNOT_BE_NULL = "El campo '%s' no puede ser nulo";
    public static final String PERSON_IS_NOT_OLDER = "La persona es menor de 18 años";
    public static final String PERSON_DUPLICATED = "La persona es duplicada";
    public static final String DOCUMENT_TYPE_NOT_FOUND = "El tipo de documento no es válido: '%s'";
    public static final String COUNTRY_NOT_FOUND = "El pais no es válido: '%s'";
    public static final String BIRTH_DATE_BAD_FORMAT = "La fecha de nacimiento tiene que tener el formato: 'dd-MM-yyyy'";
    public static final String PERSON_NOT_EXIST = "La persona ingresada no existe";
}
