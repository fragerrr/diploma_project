package kz.diploma.itsociety.atm.service.admin.client;

import kz.diploma.itsociety.atm.model.dto.ClientDTO;
import kz.diploma.itsociety.atm.repository.BankAccountRepository;
import kz.diploma.itsociety.atm.repository.CardRepository;
import kz.diploma.itsociety.atm.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AdminDeleteClientService {
    private final BankAccountRepository bankAccountRepository;
    private final CardRepository cardRepository;
    private final ClientRepository clientRepository;

    public void deleteClient(String iin){
        var clientOpt = clientRepository.findByIIN(iin);

        if(clientOpt.isPresent()){
            var client = clientOpt.get();
            var bankAccount = client.bankAccount;
            var card = bankAccount.card;

            cardRepository.delete(card);
            clientRepository.delete(client);
            bankAccountRepository.delete(bankAccount);
        }
    }
}
