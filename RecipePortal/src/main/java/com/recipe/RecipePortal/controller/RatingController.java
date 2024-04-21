package com.recipe.RecipePortal.controller;

import com.recipe.RecipePortal.entity.Rating;
import com.recipe.RecipePortal.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/RecipePortal/v1/rating")
@CrossOrigin
public class RatingController {

    @Autowired
    private RatingService ratingService;

    @PostMapping("/addRating")
    public Rating saveRating(@RequestBody Rating rating) {
        return ratingService.saveRating(rating);
    }

    @GetMapping("/viewRating/{ratingId}")
    public Rating viewRating(@PathVariable int ratingId) {
        return ratingService.getRatingById(ratingId);
    }

    @GetMapping("/viewRatingsByUser/{userId}")
    public List<Rating> viewRatingsByUser(@PathVariable int userId) {
        return ratingService.getRatingsByUserId(userId);
    }

    @GetMapping("/viewRatingsByRecipe/{recipeId}")
    public List<Rating> viewRatingsByRecipe(@PathVariable int recipeId) {
        return ratingService.getRatingsByRecipeId(recipeId);
    }

    @GetMapping("/viewAllRatings")
    public List<Rating> viewRatings() {
        return ratingService.getAllRatings();
    }

    @DeleteMapping("/deleteRating/{ratingId}")
    public String deleteRating(@PathVariable int ratingId) {
        return ratingService.deleteRating(ratingId);
    }

    @PutMapping("/updateRating/{ratingId}")
    public Rating updateRating(@PathVariable int ratingId, @RequestBody Rating updatedRating) {
        return ratingService.updateRating(ratingId, updatedRating);
    }
}
