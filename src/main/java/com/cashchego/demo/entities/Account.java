package com.cashchego.demo.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Account {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Double balance; 
    private String institution;
    
    @ManyToOne
    @JoinColumn(name = "client_id")
    private User client;
    
    @OneToMany(mappedBy = "account")
    private List<Transaction> transactions = new ArrayList<>();
    
	public Account() {
		super();
	}

	public Account(Long id, String name, Double balance, String institution) {
		super();
		this.id = id;
		this.name = name;
		this.balance = balance;
		this.institution = institution;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public String getInstitution() {
		return institution;
	}

	public void setInstitution(String institution) {
		this.institution = institution;
	}
    
    
}
