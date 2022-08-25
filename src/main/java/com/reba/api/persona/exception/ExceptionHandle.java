package com.reba.api.persona.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class ExceptionHandle{

    @ExceptionHandler(value = DataContactPersonMissedException.class)
    public ResponseEntity<Object> handleDataContactPersonMissedException(DataContactPersonMissedException ex) {
        ErrorBody errorBody = new ErrorBody(
                HttpStatus.BAD_REQUEST.value(),
                LocalDateTime.now(),
                ErrorMessage.DATA_CONTACT_PERSON_MISSED);
        return new ResponseEntity<>(errorBody, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity<Object> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        ErrorBody errorBody = new ErrorBody(
                HttpStatus.BAD_REQUEST.value(),
                LocalDateTime.now(),
                String.format(ErrorMessage.FIELD_CANNOT_BE_NULL, ex.getFieldError().getField()));
        return new ResponseEntity<>(errorBody, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = PersonIsNotOlderException.class)
    public ResponseEntity<Object> handlePersonIsNotOlderException(PersonIsNotOlderException ex) {
        ErrorBody errorBody = new ErrorBody(
                HttpStatus.BAD_REQUEST.value(),
                LocalDateTime.now(),
                ErrorMessage.PERSON_IS_NOT_OLDER);
        return new ResponseEntity<>(errorBody, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = PersonDuplicatedException.class)
    public ResponseEntity<Object> handlePersonDuplicatedException(PersonDuplicatedException ex) {
        ErrorBody errorBody = new ErrorBody(
                HttpStatus.BAD_REQUEST.value(),
                LocalDateTime.now(),
                ErrorMessage.PERSON_DUPLICATED);
        return new ResponseEntity<>(errorBody, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = DocumentTypeNotFoundException.class)
    public ResponseEntity<Object> handleDocumentTypeNotFoundException(DocumentTypeNotFoundException ex) {
        ErrorBody errorBody = new ErrorBody(
                HttpStatus.BAD_REQUEST.value(),
                LocalDateTime.now(),
                String.format(ErrorMessage.DOCUMENT_TYPE_NOT_FOUND, ex.getRejectedValue()));
        return new ResponseEntity<>(errorBody, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = CountryNotFoundException.class)
    public ResponseEntity<Object> handleCountryNotFoundException(CountryNotFoundException ex) {
        ErrorBody errorBody = new ErrorBody(
                HttpStatus.BAD_REQUEST.value(),
                LocalDateTime.now(),
                String.format(ErrorMessage.COUNTRY_NOT_FOUND, ex.getRejectedValue()));
        return new ResponseEntity<>(errorBody, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = BirthDateFormatException.class)
    public ResponseEntity<Object> handleBirthDateFormatException(BirthDateFormatException ex) {
        ErrorBody errorBody = new ErrorBody(
                HttpStatus.BAD_REQUEST.value(),
                LocalDateTime.now(),
                ErrorMessage.BIRTH_DATE_BAD_FORMAT);
        return new ResponseEntity<>(errorBody, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = BusinessException.class)
    public ResponseEntity<Object> handleBusinessException(BusinessException ex) {
        ErrorBody errorBody = new ErrorBody(
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                LocalDateTime.now(),
                ex.getMessage());
        return new ResponseEntity<>(errorBody, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(value = PersonNotFoundException.class)
    public ResponseEntity<Object> handlePersonNotFoundException(PersonNotFoundException ex) {
        ErrorBody errorBody = new ErrorBody(
                HttpStatus.BAD_REQUEST.value(),
                LocalDateTime.now(),
                ErrorMessage.PERSON_NOT_EXIST);
        return new ResponseEntity<>(errorBody, HttpStatus.BAD_REQUEST);
    }

}
