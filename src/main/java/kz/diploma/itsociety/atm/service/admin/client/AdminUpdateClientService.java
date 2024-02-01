package kz.diploma.itsociety.atm.service.admin.client;

import kz.diploma.itsociety.atm.exceptions.PersonNotFoundException;
import kz.diploma.itsociety.atm.model.dto.ClientDTO;
import kz.diploma.itsociety.atm.model.entity.Person;
import kz.diploma.itsociety.atm.repository.CardRepository;
import kz.diploma.itsociety.atm.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AdminUpdateClientService {
    private final ClientRepository clientRepository;
    private final CardRepository cardRepository;

    public Person updatePin(ClientDTO clientDTO){
        var clientOpt = clientRepository.findByIIN(clientDTO.iin);

        if(clientOpt.isPresent()){
            var client = clientOpt.get();
            client.bankAccount.card.pin = clientDTO.pin;
            cardRepository.save(client.bankAccount.card);

            return client;
        }

        throw new PersonNotFoundException(String.format("Person with iin=%s not found!", clientDTO.iin));
    }
}
