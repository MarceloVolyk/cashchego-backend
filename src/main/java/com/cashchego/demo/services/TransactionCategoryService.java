package com.cashchego.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cashchego.demo.entities.TransactionCategory;
import com.cashchego.demo.repositories.TransactionCategoryRepository;

@Service
public class TransactionCategoryService {

	@Autowired
	private TransactionCategoryRepository repository;
	
	public List<TransactionCategory> findAll(){
		return repository.findAll();
	}
	
	public TransactionCategory insert(TransactionCategory obj) {
		return repository.save(obj);
	}
}
