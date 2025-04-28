package com.cashchego.demo.entities;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

import com.cashchego.demo.entities.enums.TransactionType;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name = "tb_transaction")
public class Transaction implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Double ammount;
	private LocalDateTime creationDate;
	private Double balanceAfter;

	@ManyToOne
	@JoinColumn(name = "report_id")
	private Report report;

	@Enumerated(EnumType.STRING)
	private TransactionType type; // Enum: RECEITA, DESPESA, TRANSFERENCIA

	@ManyToOne
	@JoinColumn(name = "category_id")
	private TransactionCategory category; // Associação com Categoria (ex: "Moradia", "Lazer")

	@ManyToOne
	@JoinColumn(name = "account_id")
	@JsonIgnoreProperties({"transactions","client"})
	private Account account;

	@Transient
	private Long accountId;

	public Transaction() {
		this.creationDate = LocalDateTime.now();
	}

	public Transaction(Long id, Double ammount, TransactionType type, TransactionCategory category) {
		this.id = id;
		this.ammount = ammount;
		this.creationDate = LocalDateTime.now();
		this.type = type;
		this.category = category;
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

	public Double getBalanceAfter() {
		return balanceAfter;
	}

	public void setBalanceAfter(Double balanceAfter) {
		this.balanceAfter = balanceAfter;
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

	public TransactionCategory getCathegory() {
		return category;
	}

	public void setCathegory(TransactionCategory cathegory) {
		this.category = cathegory;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	@JsonProperty("accountId")
	public Long getAccountIdForJson() {
		return this.accountId;
	}

	@JsonProperty("accountId")
	public void setAccountIdFromJson(Long accountId) {
		this.accountId = accountId;
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
