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
public class BankAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long account_id;

    @OneToOne
    @JoinColumn(name = "card_id", referencedColumnName = "card_id")
    public Card card;

    @OneToOne
    @JoinColumn(name = "person_id", referencedColumnName = "person_id")
    public Person person;

    @Column(name = "cash")
    public Long cash;
}