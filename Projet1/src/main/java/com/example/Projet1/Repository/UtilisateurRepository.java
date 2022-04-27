package com.example.Projet1.Repository;

import com.example.Projet1.Models.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateur, Integer> {

    /*Utilisateur findBynom(String nom);*/
}
