package com.reciclaville.dto;

import lombok.Data;

@Data
public class MaterialDTO {
    private Long id;
    private String nome;
    private Double fatorCompensacaoCarbono;
}
