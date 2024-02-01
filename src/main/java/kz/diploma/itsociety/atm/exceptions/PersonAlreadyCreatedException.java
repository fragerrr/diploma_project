package kz.diploma.itsociety.atm.exceptions;

public class PersonAlreadyCreatedException extends RuntimeException{
    public PersonAlreadyCreatedException(String message) {
        super(message);
    }
}
