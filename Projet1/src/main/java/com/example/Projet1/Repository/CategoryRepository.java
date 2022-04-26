package com.example.Projet1.Repository;

import com.example.Projet1.Models.Category;
import com.example.Projet1.Models.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
