package kz.diploma.itsociety.atm.model.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import kz.diploma.itsociety.atm.model.entity.Card;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ClientDTO {
    @NotNull
    public String firstName;

    public String lastName;

    @NotNull
    public String secondName;

    @NotNull
    public String iin;

    public String pin;
}
