package com.example.bank_rest.repositories;

import com.example.bank_rest.entities.Compte;
import com.example.bank_rest.entities.TypeCompte;
import com.example.bank_rest.entities.Client;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

@RepositoryRestResource(path = "comptes", collectionResourceRel = "comptes", itemResourceRel = "compte")
public interface CompteRepository extends JpaRepository<Compte, Long> {
    @RestResource(path = "client", rel = "client")
    Client getClientById(Long id);

    @RestResource(path = "/byType")
    public List<Compte> findByType(@Param("t") TypeCompte type);
}