package com.recipe.RecipePortal.service;

import com.recipe.RecipePortal.entity.Rating;
import com.recipe.RecipePortal.repository.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class RatingService {

    @Autowired
    private RatingRepository ratingRepository;

    public Rating saveRating(Rating rating) {
        return ratingRepository.save(rating);
    }

    public List<Rating> getAllRatings() {
        return ratingRepository.findAll();
    }

    public Rating getRatingById(int ratingId) {
        return ratingRepository.findById(ratingId).orElse(null);
    }

    public List<Rating> getRatingsByUserId(int userId) {
        return ratingRepository.findAllByuserId(userId);
    }

    public List<Rating> getRatingsByRecipeId(int recipeId) {
        return ratingRepository.findAllByrecipeId(recipeId);
    }


    public String deleteRating(int ratingId) {
        ratingRepository.deleteById(ratingId);
        return "Rating deleted";
    }

    public Rating updateRating(int ratingId, Rating updatedRating) {
        Rating existingRating = ratingRepository.findById(ratingId).orElse(null);

        if (existingRating != null) {
            existingRating.setRating(updatedRating.getRating());

            return ratingRepository.save(existingRating);
        }

        return null;
    }
}
