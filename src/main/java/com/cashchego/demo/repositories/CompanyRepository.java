package com.cashchego.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cashchego.demo.entities.Company;

public interface CompanyRepository extends JpaRepository<Company, Long>{

}
