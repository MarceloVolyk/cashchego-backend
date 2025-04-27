package com.cashchego.demo.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cashchego.demo.entities.Account;
import com.cashchego.demo.entities.Transaction;
import com.cashchego.demo.repositories.AccountRepository;
import com.cashchego.demo.services.exceptions.ResourceNotFoundException;

@Service
public class AccountService {
	
	@Autowired
	private AccountRepository repository;
	
	public List<Account> findAll(){
		return repository.findAll();
	}
	
	public Account findById(Long id) {
		Optional<Account> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id)); 
	}
	
	public Account insert(Account obj) {
		return repository.save(obj);
	}
	
	public ArrayList<Transaction> findTransactions(Long id){
		return repository.findTransactionById(id);
	}
}
