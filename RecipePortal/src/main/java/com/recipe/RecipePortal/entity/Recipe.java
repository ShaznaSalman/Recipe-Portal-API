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
@Table(name = "recipe_tbl")
    public class Recipe {
        @Id
        @GeneratedValue

        private int recId;
        private String recTitle;
        private String recDescription;
        private  String recPrepstep;
        private  String recCookingtime;
        private  String recImage;
        private String userId;
        private String categoryId;
        @Column(columnDefinition = "TIMESTAMP")
        private LocalDateTime createDate;
        @PrePersist
        public void prePersist() {
             createDate = LocalDateTime.now();
        }

}

