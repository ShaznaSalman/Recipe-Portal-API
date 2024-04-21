package com.recipe.RecipePortal.repository;

import com.recipe.RecipePortal.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
    User findByUsername(String username);

}
