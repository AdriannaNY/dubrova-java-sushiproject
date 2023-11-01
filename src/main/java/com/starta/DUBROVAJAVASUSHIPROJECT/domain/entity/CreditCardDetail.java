package com.starta.DUBROVAJAVASUSHIPROJECT.domain.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class CreditCardDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "credit_card_number")
    private String creditCardNumber;

    @Column(name = "valid_from")
    private String validFrom;

    @Column(name = "valid_thru")
    private String validTHRU;

    @Column(name = "balance")
    private String balance;

}
