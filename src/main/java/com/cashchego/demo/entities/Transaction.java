package com.cashchego.demo.entities;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

import com.cashchego.demo.entities.enums.TransactionType;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
	private Double ammount;
	private LocalDateTime creationDate;
	
	@ManyToOne
	@JoinColumn(name = "report_id")
	private Report report;
	
	@Enumerated(EnumType.STRING)
    private TransactionType type;       // Enum: RECEITA, DESPESA, TRANSFERENCIA

    @ManyToOne
    @JoinColumn(name = "cathegory_id")
    private TransactionCathegory cathegory;     // Associação com Categoria (ex: "Moradia", "Lazer")

    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account; 
	
	public Transaction() {
		this.creationDate = LocalDateTime.now();
	}

	public Transaction(Long id, Double ammount, Report report, User client,
			TransactionType type, TransactionCathegory cathegory, Account account) {
		this.id = id;
		this.ammount = ammount;
		this.creationDate = LocalDateTime.now();
		this.report = report;
		this.type = type;
		this.cathegory = cathegory;
		this.account = account;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Double getAmmount() {
		return ammount;
	}


	public void setAmmount(Double ammount) {
		this.ammount = ammount;
	}


	public LocalDateTime getCreationDate() {
		return creationDate;
	}


	public void setCreationDate(LocalDateTime creationDate) {
		this.creationDate = creationDate;
	}


	public Report getReport() {
		return report;
	}


	public void setReport(Report report) {
		this.report = report;
	}

	public TransactionType getType() {
		return type;
	}


	public void setType(TransactionType type) {
		this.type = type;
	}


	public TransactionCathegory getCathegory() {
		return cathegory;
	}


	public void setCathegory(TransactionCathegory cathegory) {
		this.cathegory = cathegory;
	}


	public Account getAccount() {
		return account;
	}


	public void setAccount(Account account) {
		this.account = account;
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
