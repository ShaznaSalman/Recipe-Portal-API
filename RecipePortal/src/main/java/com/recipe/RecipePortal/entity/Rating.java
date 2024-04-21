package com.recipe.RecipePortal.entity;

import jakarta.persistence.*;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "RatingTbl")
public class Rating {
    @Id
    @GeneratedValue
    private int ratingID;
    private int userID;
    private int recID;

    private int rating;

    @Column(columnDefinition = "TIMESTAMP")
    private LocalDateTime createDate;
    @PrePersist
    public void prePersist() {
        createDate = LocalDateTime.now();
    }

}
