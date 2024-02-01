package kz.diploma.itsociety.atm.repository;

import kz.diploma.itsociety.atm.model.entity.BankAccount;
import org.springframework.data.repository.CrudRepository;

public interface BankAccountRepository extends CrudRepository<BankAccount, Long> {
}
