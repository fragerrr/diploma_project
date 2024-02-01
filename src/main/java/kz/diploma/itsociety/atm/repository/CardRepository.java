package kz.diploma.itsociety.atm.repository;

import kz.diploma.itsociety.atm.model.entity.Card;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CardRepository extends CrudRepository<Card, Long> {
    Optional<Card> findByCardNumber(String cardNumber);
}
