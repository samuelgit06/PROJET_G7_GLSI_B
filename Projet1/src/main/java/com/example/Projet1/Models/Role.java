package com.example.Projet1.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "role")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String role;

    @ManyToOne()
    @JoinColumn(name = "utilisateurId", insertable = false, updatable = false)
    private Utilisateur utilisateur;
    private int utilisateurId;

}