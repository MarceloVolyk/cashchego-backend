package com.cashchego.demo.controllers;

import java.net.URI;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.cashchego.demo.entities.Account;
import com.cashchego.demo.entities.Transaction;
import com.cashchego.demo.services.AccountService;

@RestController
@RequestMapping("/accounts")
public class AccountController {

	@Autowired
	AccountService service;
	
	@PostMapping
	public ResponseEntity<Account> insert(@RequestBody Account obj){
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}
	
	
	@GetMapping(value = "/{id}")                                    
	public ResponseEntity<ArrayList<Transaction>> findTransactions(@PathVariable Long id) {  
		ArrayList<Transaction> transactions = service.findTransactions(id);
		return ResponseEntity.ok().body(transactions);
	}
}
