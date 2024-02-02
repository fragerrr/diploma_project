package kz.diploma.itsociety.atm.controller;

import kz.diploma.itsociety.atm.exceptions.PersonAlreadyCreatedException;
import kz.diploma.itsociety.atm.exceptions.PersonNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AtmControllerAdvice {

    @ExceptionHandler(PersonNotFoundException.class)
    public ResponseEntity<String> personNotFoundException(PersonNotFoundException e){
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(PersonAlreadyCreatedException.class)
    public ResponseEntity<String> alreadyCreatedWithThisIIN(PersonAlreadyCreatedException e){
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }

}
