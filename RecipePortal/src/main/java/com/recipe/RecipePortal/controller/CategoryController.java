package com.recipe.RecipePortal.controller;

import com.recipe.RecipePortal.entity.Category;
import com.recipe.RecipePortal.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/RecipePortal/v1/category")
@CrossOrigin
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @PostMapping("/addCategory")
    public Category saveCategory(@RequestBody Category category)
    {
        return categoryService.saveCategoryDB(category);
    }


    @GetMapping("/getCategory/{categoryId}")
    public Category viewCategory(@PathVariable int categoryId)
    {
        return categoryService.getCategory(categoryId);
    }

    @GetMapping("/getByName/{categoryName}")
    public Category viewByName(@PathVariable String categoryName) {
        return categoryService.viewByName(categoryName);
    }


    @GetMapping("/getAllCategories")
    public List<Category> viewUsers()
    {
        return categoryService.getCategories();
    }


    @PutMapping("/updateCategory/{categoryId}")
    public Category updateCategory(@PathVariable int categoryId, @RequestBody Category updatedCategory)
    {
        return categoryService.updateCategory(categoryId, updatedCategory);
    }


    @DeleteMapping ("/deleteCategory/{categoryId}")
    public String deleteCategory(@PathVariable int categoryId)
    {
        return categoryService.deleteCategory(categoryId);
    }



}
