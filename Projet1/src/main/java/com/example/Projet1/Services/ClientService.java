package com.example.Projet1.Services;

import com.example.Projet1.Models.Client;
import com.example.Projet1.Repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;

    public Client saveClient(Client client){
        return clientRepository.save(client);
    }
    public List<Client> showAllClient(){
        return clientRepository.findAll();
    }

    public Client selectedClient(int id){
        Optional<Client> optional = clientRepository.findById(id);
        Client client = null;
        if (optional.isPresent())
        {
            client = optional.get();
        }
        else
        {
            throw new RuntimeException("Id introuvable");
        }
        return client;
    }

    public void deleteClient(int id){
        if(selectedClient(id) != null) {
            clientRepository.deleteById(id);
        }
    }
}
