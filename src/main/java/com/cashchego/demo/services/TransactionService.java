package com.cashchego.demo.services;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.cashchego.demo.dtos.TransactionDTO;
import com.cashchego.demo.entities.Transaction;
import com.cashchego.demo.repositories.TransactionRepository;
import com.cashchego.demo.services.exceptions.DatabaseException;
import com.cashchego.demo.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class TransactionService {

	@Autowired                         
	private TransactionRepository repository; 
	                                   
	public List<Transaction> findAll(){       
		return repository.findAll();
	}
	 
	public Transaction findById(Long id) {
		Optional<Transaction> obj = repository.findById(id);
		return obj.get();
	}
	
	public Transaction insert(Transaction obj) {
		return repository.save(obj);
	}
	
	public void delete(Long id) {
		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}
	
	public Transaction update(Long id, Transaction obj) {
		try {
			Transaction entity = repository.getReferenceById(id);
			updateData(entity, obj);
			return repository.save(entity);
		} catch(EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	private void updateData(Transaction entity, Transaction obj) {
		entity.setType(obj.getType());
		entity.setAmmount(obj.getAmmount());
		
	}
	
	//Weebsocket methods
	
    public TransactionService(TransactionRepository transactionRepository) {
        this.repository = transactionRepository;
    }

    public List<TransactionDTO> filtrarTransacoesPorDataECategoria(
            LocalDate dataInicio, 
            LocalDate dataFim, 
            Integer categoriaId) {
        
        LocalDateTime inicio = dataInicio.atStartOfDay();
        LocalDateTime fim = dataFim.plusDays(1).atStartOfDay();
        
        return repository
            .findByCreationDateBetweenAndCategoryId(inicio, fim, categoriaId)
            .stream()
            .map(TransactionDTO::new)
            .collect(Collectors.toList());
    }
}
