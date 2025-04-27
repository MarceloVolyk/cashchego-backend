package com.cashchego.demo.dtos;

import java.time.LocalDateTime;

import com.cashchego.demo.entities.Transaction;

public class TransactionDTO {
    private Long id;
    private Double amount;
    private LocalDateTime creationDate;
    private String type;
    private String categoryName;
    private String accountName;
    
    public TransactionDTO(Transaction transaction) {
        this.id = transaction.getId();
        this.amount = transaction.getAmmount();
        this.creationDate = transaction.getCreationDate();
        this.type = transaction.getType().toString();
        this.categoryName = transaction.getCathegory() != null ? 
                            transaction.getCathegory().getName() : null;
        this.accountName = transaction.getAccount() != null ? 
                         transaction.getAccount().getName() : null;
    }
    
    // Getters
    public Long getId() { return id; }
    public Double getAmount() { return amount; }
    public LocalDateTime getCreationDate() { return creationDate; }
    public String getType() { return type; }
    public String getCategoryName() { return categoryName; }
    public String getAccountName() { return accountName; }
}
