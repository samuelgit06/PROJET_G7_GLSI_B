package com.example.Projet1.Controllers;

import com.example.Projet1.Models.Role;
import com.example.Projet1.Services.RoleService;
import com.example.Projet1.Services.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("role")
public class RoleController {
    @Autowired
    private RoleService roleService;

    @Autowired
    private UtilisateurService utilisateurService;

    @GetMapping("/afficher")
    public String afficher(Model model){
        model.addAttribute("showRoles", roleService.showRoles());
        return "/role/showRole";
    }

    @GetMapping("/formRole")
    public String formRole(Role role){
        return "/role/saveRole";
    }

    @PostMapping("/save")
    public String saveRole(Role role){
        roleService.saveRole(role);
        return "redirect:/role/afficher";
    }

    @GetMapping("/edit/{id}")
    public String formEdit(@PathVariable("id") int id, Model model){
        model.addAttribute("UnRole", roleService.showOneRole(id));
        model.addAttribute("UnUtilisateur", utilisateurService.showOneUtilisateur(id));
        return "/role/formEditRole";
    }

    @PostMapping("/edit")
    public String editProduit(@ModelAttribute("role") Role role){
        roleService.saveRole(role);
        return "redirect:/role/afficher";
    }

    @GetMapping("/delete/{id}")
    public String deleteRole(@PathVariable("id") int id, Role role){
        roleService.deleteRole(id);
        return "redirect:/role/afficher";
    }

    /*@Data
    class UserToRole{
        private String nom;
        private String role;
    }*/
}
