package com.cashchego.demo.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.Date;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_transaction")
public class Transaction implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String type;
	private Double ammount;
	private Instant moment;
	private String cathegory;
	
	@ManyToOne
	@JoinColumn(name = "report_id")
	private Report report;
	
	@ManyToOne // indica a associação muitas transações para 1 cliente
	@JoinColumn(name = "client_id") // id do cliente será a chave estrangeira nesta tabela
	private User client;
	
	public Transaction() {
		super();
	}

	public Transaction(Long id, String type, Double ammount, Instant moment, String cathegory) {
		super();
		this.id = id;
		this.type = type;
		this.ammount = ammount;
		this.moment = moment;
		this.cathegory = cathegory;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Double getAmmount() {
		return ammount;
	}

	public void setAmmount(Double ammount) {
		this.ammount = ammount;
	}

	public Instant getMoment() {
		return this.moment;
	}

	public void setMoment(Instant moment) {
		this.moment = moment;
	}

	public String getCathegory() {
		return cathegory;
	}

	public void setCathegory(String cathegory) {
		this.cathegory = cathegory;
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
		Transaction other = (Transaction) obj;
		return Objects.equals(id, other.id);
	}
	
	
}
