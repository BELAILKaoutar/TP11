package com.example.bank_rest.entities; 

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "compteMobile", types = Compte.class)
public interface CompteProjection2 {
    double getSolde();
    TypeCompte getType();
}

