package com.example.Projet1.Controllers;

import com.example.Projet1.Models.Client;
import com.example.Projet1.Services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Client")
public class ClientController {
    @Autowired
    private ClientService clientService;
    @GetMapping("/Index")
    public List<Client> afficherClient(){
        return clientService.showAllClient();
    }
    @PostMapping("/Save")
    public Client save(@RequestBody Client client){
        return clientService.saveClient(client);
    }
    @GetMapping("/Edit/{id}")
    public Client showEdit(@PathVariable("id") int id){
        return clientService.selectedClient(id);
    }


    @DeleteMapping("/Delete/{id}")
    public void deleteClient(@PathVariable("id") int id){
        clientService.deleteClient(id);
    }
}
