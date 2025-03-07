package com.cashchego.demo.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_report")
public class Report implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Date date;
	private Double totalIn;
	private Double totalOut;
	private Double balance;
	
	@ManyToOne // indica a associação muitas transações para 1 cliente
	@JoinColumn(name = "client_id") // id do cliente será a chave estrangeira nesta tabela
	private User client;
	
	@OneToMany(mappedBy = "report")
	private List<Transaction> transactions = new ArrayList<>();
	
	public Report() {
		super();
	}

	public Report(Long id, Date date, Double totalIn, Double totalOut, Double balance) {
		super();
		this.id = id;
		this.date = date;
		this.totalIn = totalIn;
		this.totalOut = totalOut;
		this.balance = balance;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Double getTotalIn() {
		return totalIn;
	}

	public void setTotalIn(Double totalIn) {
		this.totalIn = totalIn;
	}

	public Double getTotalOut() {
		return totalOut;
	}

	public void setTotalOut(Double totalOut) {
		this.totalOut = totalOut;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Report other = (Report) obj;
		return Objects.equals(id, other.id);
	}
	
	
	
}
