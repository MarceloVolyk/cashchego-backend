package com.cashchego.demo.dtos;

import java.time.LocalDate;

public class TransactionFilterDTO {
    private LocalDate dataInicio;
    private LocalDate dataFim;
    private Integer categoriaId; // ID da categoria (1-3 ou outros valores)
    
    public TransactionFilterDTO() {}
    
    public TransactionFilterDTO(LocalDate dataInicio, LocalDate dataFim, Integer categoriaId) {
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.categoriaId = categoriaId;
    }
    
    // Getters e Setters
    public LocalDate getDataInicio() { return dataInicio; }
    public void setDataInicio(LocalDate dataInicio) { this.dataInicio = dataInicio; }
    
    public LocalDate getDataFim() { return dataFim; }
    public void setDataFim(LocalDate dataFim) { this.dataFim = dataFim; }
    
    public Integer getCategoriaId() { return categoriaId; }
    public void setCategoriaId(Integer categoriaId) { 
        this.categoriaId = categoriaId; 
    }
    
    public boolean isValid() {
        return dataInicio != null && 
               dataFim != null && 
               !dataFim.isBefore(dataInicio) && 
               categoriaId != null;
    }
}
