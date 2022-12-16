package com.lm2a.entities;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToMany;

@Entity
public class Customer {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name="customer_id")
private Long id;

private String name;
private String address;

@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
private List<BankAccount> bankAccounts = new ArrayList<BankAccount>();

}