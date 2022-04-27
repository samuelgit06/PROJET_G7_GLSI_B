package com.example.Projet1.Services;

import com.example.Projet1.Models.Vente;
import com.example.Projet1.Repository.VenteRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public class VenteService {
    @Autowired
    VenteRepository venteRepository;

    public vente saveVente (Vente vente){
        vente.setDateVente(LocalDate.now());
        return venteRepository.save(vente);

    }
    public List<Vente> showAllVente(){return  venteRepository.findAll();
    }
    public Vente selectedVente(int id ){
        Optional<Vente> optional = venteRepository.findById(id);
        Vente vente= null;
        if (optional.isPresent())
        {
            vente=optional.get()
        }
        else
        {
            throw new RuntimeException("Id introuvable ");

        }
        return  vente;
    }
    public void deleteVente (int id ){
        if (selectedVente(id)!=null){
            venteRepository.deleteById(id);
        }
    }
}
