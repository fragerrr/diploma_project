package kz.diploma.itsociety.atm.repository;

import kz.diploma.itsociety.atm.model.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.ListCrudRepository;

import java.util.Optional;

public interface ClientRepository extends ListCrudRepository<Person, Integer> {
    Optional<Person> findByIIN(String iin);
}
