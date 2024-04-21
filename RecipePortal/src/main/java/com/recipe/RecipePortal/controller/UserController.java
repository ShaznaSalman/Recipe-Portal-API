package com.recipe.RecipePortal.controller;

import com.recipe.RecipePortal.entity.User;
import com.recipe.RecipePortal.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/RecipePortal/v1/user")
@CrossOrigin
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/addUser")
    public User saveUser(@RequestBody User user)
    {
        return userService.saveUserDB(user);
    }


    @GetMapping("/getUser/{userId}")
    public User viewUser(@PathVariable int userId)
    {
        return userService.getUser(userId);
    }

    @GetMapping("/getByUsername/{username}")
    public User viewByUsername(@PathVariable String username) {
        return userService.viewByUsername(username);
    }

    @GetMapping("/getAllUsers")
    public List<User> viewUsers()
    {
        return userService.getUsers();
    }


    @PutMapping("/updateUser/{userId}")
    public User updateUser(@PathVariable int userId, @RequestBody User updatedUser)
    {
        return userService.updateUser(userId, updatedUser);
    }

    @PatchMapping("/patchPassword/{userId}")
    public String patchUser(@PathVariable int userId, @RequestBody String newPassword) {
        System.out.println(userId+"  "+newPassword);
        return userService.patchUser(userId, newPassword);
    }

    @DeleteMapping ("/deleteUser/{userId}")
    public String deleteUser(@PathVariable int userId)
    {
        return userService.deleteUser(userId);
    }


}
