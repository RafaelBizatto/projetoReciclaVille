package com.reciclaville.dto;
import com.reciclaville.model.Cliente;
import java.time.LocalDate;
public class DeclaracaoDTO {
    private Long id;
    private LocalDate data;
    private Cliente cliente;
    // Getters e Setters
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public LocalDate getData() {
        return data;
    }
    public void setData(LocalDate data) {
        this.data = data;
    }
    public Cliente getCliente() {
        return cliente;
    }
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}