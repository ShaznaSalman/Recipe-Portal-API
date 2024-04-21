package com.recipe.RecipePortal.service;

import com.recipe.RecipePortal.entity.User;
import com.recipe.RecipePortal.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User saveUserDB(User user){

        return userRepository.save(user);
    }

    public User getUser(int userId)
    {
        return  userRepository.findById(userId).orElse(null);
    }

    public User viewByUsername(String username) {
        return userRepository.findByUsername(username);
    }


    public List<User> getUsers(){

        return userRepository.findAll();
    }


    public User updateUser(int userId, User updatedUser) {
        User existingUser = userRepository.findById(userId).orElse(null);

        if (existingUser != null) {
            // Update the fields of the existing user with the values from updatedUser
            existingUser.setUsername(updatedUser.getUsername());
            existingUser.setFullName(updatedUser.getFullName());
            existingUser.setEmail(updatedUser.getEmail());
            existingUser.setPassword(updatedUser.getPassword());
            existingUser.setProfilePic(updatedUser.getProfilePic());

            // Save the updated user to the database
            return userRepository.save(existingUser);
        }

        return null; // User with the specified ID was not found
    }
    public String patchUser(int userId, String newPassword) {
        User user = userRepository.findById(userId).orElse(null);

        if (user != null) {
            user.setPassword(newPassword);
            userRepository.save(user);
            return "Password changed!";
        } else {
            return "User not found!";
        }

    }

    public String deleteUser(int userId)
    {
        User user = userRepository.findById(userId).orElse(null);
        if (user != null) {
            userRepository.deleteById(userId);
            return "User deleted";
        }
        else{
            return "User not found!";
        }
    }


}
