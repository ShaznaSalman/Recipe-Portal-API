package com.recipe.RecipePortal.controller;

import com.recipe.RecipePortal.entity.Recipe;
import com.recipe.RecipePortal.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/RecipePortal/v1/recipe")
@CrossOrigin
public class RecipeController {
    @Autowired
    private RecipeService recipeService;

    @PostMapping("/addRecipe")
    public Recipe saveRecipe(@RequestBody Recipe recipe)
    {
        return recipeService.saveRecipeDB(recipe);
    }

    @GetMapping("/viewRecipe/{recId}")
    public Recipe viewRecipe(@PathVariable int recId)
    {
        return recipeService.getRecipe(recId);
    }

    @GetMapping("/getRecipeByTitle/{recTitle}")
    public Recipe getRecipesOfUser(@PathVariable String recTitle){
        return recipeService.viewByTitle(recTitle);
    }

    @GetMapping("/getRecipesOfUser/{userId}")
    public List<Recipe> getRecipesOfUsers(@PathVariable int userId){
        return recipeService.getByUserId(userId);
    }

    @GetMapping("/getRecipesOfCategory/{categoryId}")
    public List<Recipe> getRecipesOfCategory(@PathVariable int categoryId){
        return recipeService.getByCategoryId(categoryId);
    }

    @GetMapping("/viewAllRecipes")
    public List<Recipe> viewAllRecipes()
    {
        return recipeService.getAllRecipes();
    }

    @DeleteMapping ("/deleteRecipe/{recId}")
    public String deleteUser(@PathVariable int recId)
    {
        return recipeService.deleteRecipe(recId);
    }

    @PutMapping("/updateRecipe/{recId}")
   public Recipe updateRecipe(@PathVariable int recId, @RequestBody Recipe updatedRecipe) {
        return recipeService.updateRecipe(recId, updatedRecipe);
    }

}
