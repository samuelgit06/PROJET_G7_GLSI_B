package com.example.Projet1.Services;

import com.example.Projet1.Models.Category;
import com.example.Projet1.Repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    //enregistrer une categorie
    public void saveCategory(Category category){
    categoryRepository.save(category);
    }

    //afficher liste de categorie
    public List<Category> showCategory(){
        return categoryRepository.findAll();
    }

    //trouver une categorie spécifique
    public Category showOneCategory(int id){
        return categoryRepository.findById(id).get();
    }

    //supprimer une categorie
    public void deleteCategory(int id)
    {
        categoryRepository.deleteById(id);
    }
}
