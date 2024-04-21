package com.recipe.RecipePortal.repository;

import com.recipe.RecipePortal.entity.Comment;
import com.recipe.RecipePortal.entity.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Integer> {
    @Query(value = "SELECT * FROM comment_tbl where userid = :userId",nativeQuery = true)
    List<Comment> findAllByuserId(int userId);

    @Query(value = "SELECT * FROM comment_tbl where recid = :recipeId",nativeQuery = true)
    List<Comment> findAllByrecipeId(int recipeId);
}
