package com.example.Projet1.Controllers;

import com.example.Projet1.Models.Utilisateur;
import com.example.Projet1.Services.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("utilisateurs")
public class UtilisateurController {
    @Autowired
    private UtilisateurService utilisateurService;

    @GetMapping("/afficher")
    public String afficher(Model model){
        model.addAttribute("Utilisateurs", utilisateurService.showUtilisateurs());
        return "/utilisateurs/showUtilisateur";
    }

    @GetMapping("/formUtilisateur")
    public String formUtilisateur() {
        return "utilisateurs/formUtilisateur";
    }


    @PostMapping("/save")
    public String saveUtilisateur(Utilisateur utilisateur){
        utilisateurService.saveUtilisateur(utilisateur);
        return "redirect:/utilisateurs/afficher";
    }

    @GetMapping("/edit/{id}")
    public String EditformUtilisateur(@PathVariable("id") int id, Model model){
        model.addAttribute("unUtilisateur", utilisateurService.showOneUtilisateur(id));
        return "utilisateurs/formEditUtilisateur";
    }

    @PostMapping("/edit")
    public String editUtilisateur(Utilisateur utilisateur){
        utilisateurService.saveUtilisateur(utilisateur);
        return "redirect:/utilisateurs/afficher";
    }

    @GetMapping("/delete/{id}")
    public String deleteUtilisateur(@PathVariable("id") int id, Utilisateur utilisateur){
        utilisateurService.deleteUtilisateur(id);
        return "redirect:/utilisateurs/afficher";
    }


    /*@Data
    class RoletoUser{
        private String nom;
        private String role;
    }*/
}

