package kz.diploma.itsociety.atm.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer card_id;

    @Column(name = "card_number")
    public String cardNumber;

    @Column(name = "expired_date")
    public LocalDateTime expiredDate;

    @Column(name = "cvv")
    public String cvv;

    @Column(name = "pin")
    public String pin;

    @OneToOne(mappedBy = "card")
    public BankAccount bankAccount;
}
