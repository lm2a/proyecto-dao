package com.lm2a.entities;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;


@Entity
public class BankAccount {
    @Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name="bankaccount_id")
private Long id;
private String number;
private Float deposit;

@ManyToMany
private List<Customer> customers = new ArrayList<Customer>();
}