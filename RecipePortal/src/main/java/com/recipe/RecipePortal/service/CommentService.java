package com.recipe.RecipePortal.service;

import com.recipe.RecipePortal.entity.Comment;
import com.recipe.RecipePortal.entity.Rating;
import com.recipe.RecipePortal.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {
    @Autowired
    private CommentRepository commentRepository;

    public Comment createComment(Comment comment) {
        return commentRepository.save(comment);
    }

    public List<Comment> getAllComments() {
        return commentRepository.findAll();
    }

    public Comment getCommentById(int commentId) {
        return commentRepository.findById(commentId).orElse(null);
    }

    public List<Comment> getCommentsByUserId(int userId) {
        return commentRepository.findAllByuserId(userId);
    }

    public List<Comment> getCommentsByRecipeId(int recipeId) {
        return commentRepository.findAllByrecipeId(recipeId);
    }

    public Comment updateComment(int commentId, Comment updatedComment) {
        Comment existingComment = commentRepository.findById(commentId).orElse(null);
        if (existingComment != null) {
            existingComment.setComment(updatedComment.getComment());
            return commentRepository.save(existingComment);
        }
        return null;
    }

    public String deleteComment(int commentId) {
        commentRepository.deleteById(commentId);
        return "Comment deleted";
    }
}

