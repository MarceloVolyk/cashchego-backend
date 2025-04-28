package com.cashchego.demo.repositories;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cashchego.demo.entities.Account;
import com.cashchego.demo.entities.Transaction;
import com.cashchego.demo.entities.User;

public interface AccountRepository extends JpaRepository<Account, Long>{

	ArrayList<Transaction> findTransactionById(Long id);
	
	List<Account> findByClientId(Long clientId);
}
