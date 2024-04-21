package com.recipe.RecipePortal.service;

import com.recipe.RecipePortal.entity.Category;
import com.recipe.RecipePortal.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    public Category saveCategoryDB(Category category){

        return categoryRepository.save(category);
    }

    public Category getCategory(int categoryId)
    {
        return  categoryRepository.findById(categoryId).orElse(null);
    }

    public Category viewByName(String categoryName) {
        return categoryRepository.findByCategoryName(categoryName);
    }


    public List<Category> getCategories(){

        return categoryRepository.findAll();
    }


    public Category updateCategory(int categoryId, Category updatedCategory) {
        Category category = categoryRepository.findById(categoryId).orElse(null);

        if (category != null) {
            category.setCategoryName(updatedCategory.getCategoryName());
            category.setCategoryDescription(updatedCategory.getCategoryDescription());

            return categoryRepository.save(category);
        }

        return null;
    }

    public String deleteCategory(int categoryId)
    {
        Category category = categoryRepository.findById(categoryId).orElse(null);
        if (category != null) {
            categoryRepository.deleteById(categoryId);
            return "Category deleted";
        }
        else{
            return "Category not found!";
        }
    }


}
