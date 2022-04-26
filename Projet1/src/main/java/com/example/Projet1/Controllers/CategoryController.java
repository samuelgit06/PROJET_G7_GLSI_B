package com.example.Projet1.Controllers;

import com.example.Projet1.Models.Category;
import com.example.Projet1.Services.CategoryService;
import com.example.Projet1.Services.ProduitService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/Category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/afficher")
    public String ShowListCategory(Model model) {
        model.addAttribute("ListCategory", categoryService.showCategory());
        return "Category/showCategory";
    }

    @GetMapping("/formCategory")
    public String formCategory() {
        return "Category/formCategory";
    }

    @PostMapping("/save")
    public String saveCategory(Category category) {
        categoryService.saveCategory(category);
        return "redirect:/Category/afficher";
    }

    @GetMapping("/edit/{id}")
    public String editFormCategorie(@PathVariable("id") int id, Model model) {
        model.addAttribute("uneCategorie", categoryService.showOneCategory(id));
        return "Category/formEditCategory";
    }

    @PostMapping("/edit")
    public String editCategory(@ModelAttribute("Category") Category category) {
        categoryService.saveCategory(category);
        return "redirect:/Category/afficher";
    }


    @GetMapping("delete/{id}")
    public String deleteCategory(@PathVariable("id") int id) {
        categoryService.deleteCategory(id);
        return "redirect:/Category/afficher";
    }


}
