package com.recipe.RecipePortal.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "categoryTbl")
public class Category {
    @Id
    @GeneratedValue
    private int categoryId;
    private String categoryName;
    private String categoryDescription;
}
