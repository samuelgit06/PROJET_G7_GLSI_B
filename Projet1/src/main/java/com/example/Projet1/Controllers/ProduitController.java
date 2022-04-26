package com.example.Projet1.Controllers;

import com.example.Projet1.Models.Produit;
import com.example.Projet1.Services.CategoryService;
import com.example.Projet1.Services.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("produits")
public class ProduitController {

    @Autowired
    private ProduitService produitService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/afficher")
    public String displayProduct(Model model)
    {
        model.addAttribute("produits", produitService.showProduits());
        return "produits/showProduit";
    }

    @GetMapping("/form")
    public String renseigner(Model model)
    {
        model.addAttribute("listCategory",categoryService.showCategory());
        return "produits/saveProduit";
    }

    @PostMapping("/save")
    public String saveProduit(Produit produit)
    {

        produit.setDateCreation(LocalDate.now());
        produit.setQtStock(0);
        produitService.saveProduit(produit);
        return "redirect:/produits/afficher";
    }

    @GetMapping("edit/{id}")
    public String FormEdit(@PathVariable("id") int id , Model model){
        model.addAttribute("UnProduit", produitService.showOneProduit(id));
        model.addAttribute("UneCategorie", categoryService.showCategory());
        return "/produits/formEdit";
    }

    @PostMapping("/edit")
    public String editProduit(@ModelAttribute("produit") Produit produit){
        produitService.saveProduit((produit));
        return "redirect:/produits/afficher";
    }


    @GetMapping ("delete/{id}")
    public String deleteProduit(@PathVariable("id") int id)
    {
        produitService.deleteProduit(id);
        return "redirect:/produits/afficher";
    }


}
