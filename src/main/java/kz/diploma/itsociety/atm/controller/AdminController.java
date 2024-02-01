package kz.diploma.itsociety.atm.controller;

import kz.diploma.itsociety.atm.exceptions.PersonAlreadyCreatedException;
import kz.diploma.itsociety.atm.exceptions.PersonNotFoundException;
import kz.diploma.itsociety.atm.model.dto.ClientDTO;
import kz.diploma.itsociety.atm.model.entity.Person;
import kz.diploma.itsociety.atm.service.admin.impl.AdminServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/admin")
public class AdminController {
    private final AdminServiceImpl adminService;

    @GetMapping("/clients")
    public ResponseEntity<List<Person>> getClients(){
        var list = adminService.getPersons();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/client/{iin}")
    public ResponseEntity<Person> getClient(@PathVariable(name = "iin") String iin){
        var person = adminService.getPersonByIIN(iin);
        return new ResponseEntity<>(person, HttpStatus.OK);
    }

    @PostMapping("/new-client")
    public ResponseEntity<HttpStatus> newClient(ClientDTO clientDTO){
        adminService.createPerson(clientDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/delete/{iin}")
    public ResponseEntity<String > deleteClient(@PathVariable(name = "iin") String iin){
        adminService.deletePerson(iin);
        return new ResponseEntity<>(String.format("User with iin=%s was removed", iin), HttpStatus.OK);
    }

    @PostMapping("/update-pin")
    public ResponseEntity<String> updateClient(ClientDTO clientDTO){
        adminService.updatePerson(clientDTO);
        return new ResponseEntity<>(String.format("For user with iin=%s pin was updated", clientDTO.iin), HttpStatus.ACCEPTED);
    }
}
