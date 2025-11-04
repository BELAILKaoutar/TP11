package com.example.bank_rest;

import com.example.bank_rest.entities.Client;
import com.example.bank_rest.entities.Compte;
import com.example.bank_rest.entities.TypeCompte;
import com.example.bank_rest.repositories.ClientRepository;
import com.example.bank_rest.repositories.CompteRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class MsBanqueApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsBanqueApplication.class, args);
    }

    // CommandLineRunner pour tester l'application
    public CommandLineRunner start(ClientRepository clientRepository, CompteRepository compteRepository) {
        return args -> {
            // Création d'un client
            Client client1 = new Client("Kaoutar", "Belail");

            // Création de comptes
            Compte compte1 = new Compte(1000, new Date(), TypeCompte.COURANT, client1);
            Compte compte2 = new Compte(5000, new Date(), TypeCompte.EPARGNE, client1);

            // Association
            client1.addCompte(compte1);
            client1.addCompte(compte2);

            // Sauvegarde dans la base
            clientRepository.save(client1);

            // Affichage
            clientRepository.findAll().forEach(System.out::println);
            compteRepository.findAll().forEach(System.out::println);
        };
    }
}
