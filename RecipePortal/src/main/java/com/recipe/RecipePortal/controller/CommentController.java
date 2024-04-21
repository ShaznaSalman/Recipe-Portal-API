package com.recipe.RecipePortal.controller;

import com.recipe.RecipePortal.entity.Comment;
import com.recipe.RecipePortal.entity.Rating;
import com.recipe.RecipePortal.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/RecipePortal/v1/comment")
@CrossOrigin
public class CommentController {
    @Autowired
    private CommentService commentService;


    @PostMapping("/createComment")
    public Comment createComment(@RequestBody Comment comment) {
        return commentService.createComment(comment);
    }

    @GetMapping("/getComment/{commentId}")
    public Comment getCommentById(@PathVariable int commentId) {
        return commentService.getCommentById(commentId);
    }

    @GetMapping("/viewCommentsByUser/{userId}")
    public List<Comment> viewCommentsByUser(@PathVariable int userId) {
        return commentService.getCommentsByUserId(userId);
    }

    @GetMapping("/viewCommentsByRecipe/{recipeId}")
    public List<Comment> viewCommentsByRecipe(@PathVariable int recipeId) {
        return commentService.getCommentsByRecipeId(recipeId);
    }
    @GetMapping("/getAllComments")
    public List<Comment> getAllComments() {
        return commentService.getAllComments();
    }

    @PutMapping("/updateComment/{commentId}")
    public Comment updateComment(@PathVariable int commentId, @RequestBody Comment updatedComment) {
        return commentService.updateComment(commentId, updatedComment);
    }

    @DeleteMapping("/deleteComment/{commentId}")
    public String deleteComment(@PathVariable int commentId) {
        return commentService.deleteComment(commentId);
    }
}
