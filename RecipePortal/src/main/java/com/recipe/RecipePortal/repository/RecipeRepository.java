package com.recipe.RecipePortal.repository;

import com.recipe.RecipePortal.entity.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RecipeRepository extends JpaRepository<Recipe,Integer> {
    Recipe findByRecTitle(String recTitle);

//    List<Recipe> findAllById(int userId);
    @Query(value = "SELECT * FROM recipe_tbl where user_id = :userId",nativeQuery = true)
    List<Recipe> findAllByuserId(int userId);

    @Query(value = "SELECT * FROM recipe_tbl where category_id = :categoryId",nativeQuery = true)
    List<Recipe> findAllBycategoryId(int categoryId);
}
