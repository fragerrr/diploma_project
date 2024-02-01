package kz.diploma.itsociety.atm.service.admin.impl;

import kz.diploma.itsociety.atm.model.dto.ClientDTO;
import kz.diploma.itsociety.atm.model.entity.Person;
import kz.diploma.itsociety.atm.repository.ClientRepository;
import kz.diploma.itsociety.atm.service.admin.client.AdminCreateClientService;
import kz.diploma.itsociety.atm.service.admin.client.AdminDeleteClientService;
import kz.diploma.itsociety.atm.service.admin.client.AdminUpdateClientService;
import kz.diploma.itsociety.atm.service.admin.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService {
    private final AdminCreateClientService createService;
    private final AdminDeleteClientService deleteService;
    private final AdminUpdateClientService updateService;
    private final ClientRepository clientRepository;

    @Override
    public List<Person> getPersons() {
        return clientRepository.findAll();
    }

    @Override
    public void deletePerson(String iin) {
        deleteService.deleteClient(iin);

    }

    @Override
    public void updatePerson(ClientDTO clientDTO) {
        updateService.updatePin(clientDTO);
    }

    @Override
    public Person getPersonByIIN(String iin) {
        return null;
    }

    @Override
    public void createPerson(ClientDTO clientDTO) {
        createService.createNewClient(clientDTO);
    }
}
