package com.example.bank_rest.repositories;

import com.example.bank_rest.entities.Client;
import com.example.bank_rest.entities.Compte;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

@RepositoryRestResource(path = "clients") 
public interface ClientRepository extends JpaRepository<Client, Long> {
    @RestResource(path = "comptes", rel = "comptes")
    List<Compte> findComptesById(Long id);
}

