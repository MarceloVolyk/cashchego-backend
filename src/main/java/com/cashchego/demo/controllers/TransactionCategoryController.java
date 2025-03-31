package com.cashchego.demo.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.cashchego.demo.entities.TransactionCategory;
import com.cashchego.demo.services.TransactionCategoryService;

@RestController
@RequestMapping("/transactionCategories")
public class TransactionCategoryController {

	@Autowired
	private TransactionCategoryService service;
	
	@GetMapping
	public ResponseEntity<List<TransactionCategory>> findAll(){
		List<TransactionCategory> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@PostMapping
	public ResponseEntity<TransactionCategory> insert(@RequestBody TransactionCategory obj){
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}
}
