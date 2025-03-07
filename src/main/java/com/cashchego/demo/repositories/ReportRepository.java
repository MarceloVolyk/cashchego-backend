package com.cashchego.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cashchego.demo.entities.Report;

public interface ReportRepository extends JpaRepository<Report, Long>{

}
