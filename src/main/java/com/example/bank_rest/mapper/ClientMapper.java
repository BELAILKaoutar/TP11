package com.example.bank_rest.mapper;

import com.example.bank_rest.dto.ClientDTO;
import com.example.bank_rest.entities.Client;

public class ClientMapper {
    public static ClientDTO toDTO(Client client) {
        return new ClientDTO(client.getNom(), client.getPrenom());
    }
}
