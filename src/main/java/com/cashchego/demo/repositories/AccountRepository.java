package com.cashchego.demo.repositories;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cashchego.demo.entities.Account;
import com.cashchego.demo.entities.Transaction;

public interface AccountRepository extends JpaRepository<Account, Long>{

	ArrayList<Transaction> findTransactionById(Long id);
}
