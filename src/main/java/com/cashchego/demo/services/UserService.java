package com.cashchego.demo.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.cashchego.demo.entities.Account;
import com.cashchego.demo.entities.User;
import com.cashchego.demo.repositories.AccountRepository;
import com.cashchego.demo.repositories.UserRepository;
import com.cashchego.demo.services.exceptions.DatabaseException;
import com.cashchego.demo.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class UserService {
	
	@Autowired                         //injeção de dependência -> a interface UserRepository
	private UserRepository repository; //não necessita da anotação @Repository para registro,
	                                   //porque ela herda propriedades da interface JPARepository,
									   //que já é nativamente registrada
	@Autowired
	private AccountRepository accRepo;
	
	public List<User> findAll(){       
		return repository.findAll();
	}
	
	public User findById(Long id) {
		Optional<User> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	 // Método para buscar todas as contas e transações de um usuário
    public List<Account> getUserAccountsWithTransactions(Long userId) {
        User user = repository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        
        List<Account> accounts = accRepo.findByClientId(userId);
        return accounts;
        
    }
	
	public User insert(User obj) {
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
	
	public User update(Long id, User obj) {
		try {
			User entity = repository.getReferenceById(id);
			updateData(entity, obj);
			return repository.save(entity);
		} catch(EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	private void updateData(User entity, User obj) {
		entity.setName(obj.getName());
		entity.setEmail(obj.getEmail());
		entity.setPhone(obj.getPhone());
		
	}
}
