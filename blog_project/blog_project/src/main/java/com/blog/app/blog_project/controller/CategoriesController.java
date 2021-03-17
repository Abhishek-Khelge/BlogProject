package com.blog.app.blog_project.controller;

import com.blog.app.blog_project.entity.Categories;
import com.blog.app.blog_project.entity.User;
import com.blog.app.blog_project.service.CategoriesService;
import com.blog.app.blog_project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CategoriesController {

    @Autowired
    CategoriesService categoriesService;

    @GetMapping("/Categories")
    public List<Categories> getAll() {
        return categoriesService.getAllCategories();
    }

    @PostMapping("/Categories")
    public Categories addCategory(@RequestBody Categories category) {
        return categoriesService.addCategory(category);
    }

    @PutMapping("/Categories")
    public Categories updateCategory(@RequestBody Categories category) {
        return categoriesService.updateCategory(category);
    }

    @DeleteMapping("/categories/{id}")
    public String deleteCategory(@PathVariable("id") int categoryId) {
        boolean flag = categoriesService.deletecategory(categoryId);
        if (flag)
            return "category entry deleted";
        else
            return " deletion failed";
    }
}
