package com.cashchego.demo.repositories;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cashchego.demo.entities.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long>{

	 @Query("SELECT t FROM Transaction t WHERE " +
	           "t.creationDate BETWEEN :inicio AND :fim AND " +
	           "t.category.id = :categoriaId")
	    List<Transaction> findByCreationDateBetweenAndCategoryId(
	        @Param("inicio") LocalDateTime inicio,
	        @Param("fim") LocalDateTime fim,
	        @Param("categoriaId") Integer categoriaId
	    );
}
