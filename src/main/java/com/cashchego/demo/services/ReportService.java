package com.cashchego.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cashchego.demo.entities.Report;
import com.cashchego.demo.repositories.ReportRepository;

@Service
public class ReportService {

	@Autowired                         
	private ReportRepository repository; 
	                                   
	public List<Report> findAll(){       
		return repository.findAll();
	}
	
	public Report findById(Long id) {
		Optional<Report> obj = repository.findById(id);
		return obj.get();
	}
}
