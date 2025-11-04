package com.example.bank_rest.controllers;
import com.example.bank_rest.dto.ClientDTO;
import com.example.bank_rest.dto.CompteMobileDTO;
import com.example.bank_rest.dto.CompteSoldeDTO;
import com.example.bank_rest.entities.Compte;

import com.example.bank_rest.repositories.CompteRepository;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/banque/comptes")
public class CompteController {

    private final CompteRepository compteRepository;

    public CompteController(CompteRepository compteRepository) {
        this.compteRepository = compteRepository;
    }

    // Endpoint pour récupérer le client d’un compte (DTO)
    @GetMapping("/{id}/client")
    public ClientDTO getClientByCompte(@PathVariable Long id) {
        Compte compte = compteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Compte non trouvé"));
        return new ClientDTO(
                compte.getClient().getNom(),
                compte.getClient().getPrenom()
        );
    }

    // Projection : solde uniquement
    @GetMapping("/solde")
    public List<CompteSoldeDTO> getComptesSolde() {
        return compteRepository.findAll()
                .stream()
                .map(c -> new CompteSoldeDTO(c.getSolde()))
                .collect(Collectors.toList());
    }

    // Projection : solde + type
    @GetMapping("/mobile")
    public List<CompteMobileDTO> getComptesMobile() {
        return compteRepository.findAll()
                .stream()
                .map(c -> new CompteMobileDTO(c.getSolde(), c.getType()))
                .collect(Collectors.toList());
    }
}

