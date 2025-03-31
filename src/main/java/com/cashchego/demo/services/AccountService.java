package com.cashchego.demo.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cashchego.demo.entities.Account;
import com.cashchego.demo.entities.Transaction;
import com.cashchego.demo.repositories.AccountRepository;

@Service
public class AccountService {
	
	@Autowired
	private AccountRepository repository;
	
	public Account insert(Account obj) {
		return repository.save(obj);
	}
	
	public ArrayList<Transaction> findTransactions(Long id){
		return repository.findTransactionById(id);
	}
}
