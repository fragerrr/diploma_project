package kz.diploma.itsociety.atm.service.admin;

import kz.diploma.itsociety.atm.model.dto.ClientDTO;
import kz.diploma.itsociety.atm.model.entity.Person;

import java.util.List;

public interface AdminService {
    List<Person> getPersons();

    void deletePerson(String iin);

    void updatePerson(ClientDTO clientDTO);

    Person getPersonByIIN(String iin);

    void createPerson(ClientDTO clientDTO);
}
