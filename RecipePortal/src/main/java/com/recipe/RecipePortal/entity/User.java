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
@Table(name = "userTbl")
public class User {
    @Id
    @GeneratedValue

    private int userId;
    private String username;
    private String fullName;
    private  String email;
    private  String password;
    private  String profilePic;
    @Column(columnDefinition = "TIMESTAMP")
    private LocalDateTime createDate;
    @PrePersist
    public void prePersist() {
        createDate = LocalDateTime.now();
    }

}


