package com.cashchego.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cashchego.demo.entities.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long>{

}
