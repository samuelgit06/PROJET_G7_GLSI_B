package com.example.Projet1.Controllers;

import com.example.Projet1.Models.Approvisionnement;
import com.example.Projet1.Services.ApprovisionnementService;
import com.example.Projet1.Services.CategoryService;
import com.example.Projet1.Services.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("approvisionnement")
public class ApprovisionnementController {

    @Autowired
    ApprovisionnementService approvisionnementService;

    @Autowired
    ProduitService produitService;

    @Autowired
    CategoryService categoryService;


    @GetMapping("/form")
    public  String ShowListProduit(Model model)
    {
        model.addAttribute("listProduit",produitService.showProduits());
        return "approvisionnement/saveApprovisionnement";
    }

    @PostMapping("/save")
    public String saveApprovisionnement(Approvisionnement approvisionnement)
    {
        approvisionnementService.saveApprovisionnement(approvisionnement);
        return "redirect:/produits/afficher";
    }

    @GetMapping("/approvisionner/{id}")
    public String FormEdit(@PathVariable("id") int id , Model model){
        model.addAttribute("UnProduit", produitService.showOneProduit(id));
        System.out.println("id = "+produitService.showOneProduit(id));
        return "approvisionnement/formApprovisionnement";
    }
}