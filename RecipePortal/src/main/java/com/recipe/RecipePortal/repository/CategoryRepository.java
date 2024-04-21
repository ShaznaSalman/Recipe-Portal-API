package com.recipe.RecipePortal.repository;

import com.recipe.RecipePortal.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Integer> {
    Category findByCategoryName(String categoryName);
}
