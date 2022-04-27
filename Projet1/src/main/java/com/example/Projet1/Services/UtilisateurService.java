package com.example.Projet1.Services;

import com.example.Projet1.Models.Utilisateur;
import com.example.Projet1.Repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UtilisateurService {

    @Autowired
    private UtilisateurRepository utilisateurRepository;

    public List<Utilisateur> showUtilisateurs(){
        return utilisateurRepository.findAll();
    }

    public void saveUtilisateur(Utilisateur utilisateur){
        utilisateurRepository.save(utilisateur);
    }

    public Utilisateur showOneUtilisateur(int id){
        return utilisateurRepository.findById(id).get();
    }

    public void deleteUtilisateur(int id){

        utilisateurRepository.deleteById(id);
    }

}
