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
@Table(name = "commentTbl")
public class Comment {
    @Id
    @GeneratedValue
    private int commentID;
    private int userID;
    private int recID;

    @Column(columnDefinition = "TEXT")
    private String comment;

    @Column(columnDefinition = "TIMESTAMP")
    private LocalDateTime createDate;
    @PrePersist
    public void prePersist() {
        createDate = LocalDateTime.now();
    }

}
