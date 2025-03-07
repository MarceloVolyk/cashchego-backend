package com.cashchego.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cashchego.demo.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
