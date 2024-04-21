package com.recipe.RecipePortal.repository;

import com.recipe.RecipePortal.entity.Rating;
import com.recipe.RecipePortal.entity.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RatingRepository extends JpaRepository<Rating,Integer>{
    @Query(value = "SELECT * FROM rating_tbl where userid = :userId",nativeQuery = true)
    List<Rating> findAllByuserId(int userId);

    @Query(value = "SELECT * FROM rating_tbl where recid = :recipeId",nativeQuery = true)
    List<Rating> findAllByrecipeId(int recipeId);
}
