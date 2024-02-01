package kz.diploma.itsociety.atm.service.admin.client;

import kz.diploma.itsociety.atm.exceptions.PersonAlreadyCreatedException;
import kz.diploma.itsociety.atm.model.dto.ClientDTO;
import kz.diploma.itsociety.atm.model.entity.BankAccount;
import kz.diploma.itsociety.atm.model.entity.Card;
import kz.diploma.itsociety.atm.model.entity.Person;
import kz.diploma.itsociety.atm.repository.BankAccountRepository;
import kz.diploma.itsociety.atm.repository.CardRepository;
import kz.diploma.itsociety.atm.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Random;
import java.util.stream.IntStream;

@Service
@RequiredArgsConstructor
public class AdminCreateClientService {
    private final ClientRepository clientRepository;
    private final CardRepository cardRepository;
    private final BankAccountRepository bankAccountRepository;

    public void createNewClient(ClientDTO clientDTO){
        var data = clientRepository.findByIIN(clientDTO.iin);
        if(data.isEmpty()){
            throw new PersonAlreadyCreatedException("Person already created");
        }

        var newPerson = Person.builder()
                .firstName(clientDTO.firstName)
                .secondName(clientDTO.secondName)
                .lastName(Objects.nonNull(clientDTO.lastName) ? clientDTO.lastName : null)
                .IIN(clientDTO.iin)
                .build();

        createBankAccount(clientRepository.save(newPerson), clientDTO.pin);
    }

    private void createBankAccount(Person person, String pin){
        var newAccount = BankAccount.builder()
                .card(createCard(pin))
                .cash(0L)
                .person(person)
                .build();

        bankAccountRepository.save(newAccount);
    }

    private Card createCard(String pin){
        var newCard = Card.builder()
                .pin(pin)
                .cvv(generateCVV())
                .cardNumber(generateCard())
                .expiredDate(LocalDateTime.now().plusYears(4L))
                .build();

        return cardRepository.save(newCard);
    }

    private String generateCVV(){
        var random = new Random(102);
        var sb = new StringBuilder();

        IntStream.rangeClosed(1, 3)
                .mapToObj(i -> random.nextInt())
                .forEach(sb::append);

        return sb.toString();
    }

    private String generateCard(){
        var i = 0;

        while(true){
            var generatedCardNumber = generateCardNumber(i);
            var cardOpt = cardRepository.findByCardNumber(generatedCardNumber);

            if(cardOpt.isEmpty()){
                return generatedCardNumber;
            }

            i++;
        }

    }

    private String generateCardNumber(Integer seed){
        var random = new Random(seed);
        var sb = new StringBuilder();

        IntStream.rangeClosed(1,16)
                .mapToObj(i -> random.nextInt())
                .forEach(sb::append);

        return sb.toString();
    }

}
