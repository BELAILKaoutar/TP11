package com.example.bank_rest.dto;

import com.example.bank_rest.entities.TypeCompte;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CompteMobileDTO {
    private double solde;
    private TypeCompte type;
}
