package com.recipe.RecipePortal.service;

import com.recipe.RecipePortal.entity.Category;
import com.recipe.RecipePortal.entity.Recipe;
import com.recipe.RecipePortal.entity.User;
import com.recipe.RecipePortal.repository.CategoryRepository;
import com.recipe.RecipePortal.repository.RecipeRepository;
import com.recipe.RecipePortal.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class RecipeService {
    @Autowired
    RecipeRepository recipeRepository;

    @Autowired
    UserRepository userRepository;


    public Recipe saveRecipeDB(Recipe recipe) {
            return recipeRepository.save(recipe);
    }


    public Recipe getRecipe(int recId)
    {
        return  recipeRepository.findById(recId).orElse(null);
    }

    public Recipe viewByTitle(String recTitle)
    {
        return recipeRepository.findByRecTitle(recTitle);
    }
    public List<Recipe> getByUserId(int userId){

        return recipeRepository.findAllByuserId(userId);
    }

    public List<Recipe> getByCategoryId(int categoryId){

        return recipeRepository.findAllBycategoryId(categoryId);
    }
    public List<Recipe> getAllRecipes(){

        return recipeRepository.findAll();
    }

    public String deleteRecipe(int recId)
    {
        recipeRepository.deleteById(recId);
        return "Recipe deleted";
    }

    public Recipe updateRecipe(int id, Recipe updatedRecipe) {
        Recipe existingRecipe = recipeRepository.findById(id).orElse(null);

        if (existingRecipe != null) {
            existingRecipe.setRecTitle(updatedRecipe.getRecTitle());
            existingRecipe.setRecDescription(updatedRecipe.getRecDescription());
            existingRecipe.setRecPrepstep(updatedRecipe.getRecPrepstep());
            existingRecipe.setRecCookingtime(updatedRecipe.getRecCookingtime());
            existingRecipe.setRecImage(updatedRecipe.getRecImage());

            return recipeRepository.save(existingRecipe);
        }

        return null;
    }

}
