package com.blog.app.blog_project.service;

import com.blog.app.blog_project.entity.Categories;
import com.blog.app.blog_project.entity.User;
import com.blog.app.blog_project.repository.CategoriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriesService {

    @Autowired
    CategoriesRepository categoriesRepository;

    public List<Categories> getAllCategories() {
        return categoriesRepository.findAll();
    }

    public Categories addCategory(Categories category) {
        return categoriesRepository.save(category);
    }

    public Categories updateCategory(Categories category) {
        Categories category1 = categoriesRepository.findById(category.getCategoriesId()).get();
        category1.setCategoriesType(category.getCategoriesType());
        categoriesRepository.save(category1);
        return category1;
    }

    public boolean deletecategory(int categoryId) {
        Categories category1 = categoriesRepository.findById(categoryId).get();
        try {
            categoriesRepository.delete(category1);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
