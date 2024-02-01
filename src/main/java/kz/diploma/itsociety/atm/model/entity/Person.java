package kz.diploma.itsociety.atm.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer person_id;

    @Column(name = "first_name")
    public String firstName;

    @Column(name = "last_name")
    public String lastName;

    @Column(name = "second_name")
    public String secondName;

    @Column(name = "iin", unique = true)
    public String IIN;

    @OneToOne(mappedBy = "person")
    public BankAccount bankAccount;
}
