package com.eCommerceWeb.eCommerceWeb.service;

import com.eCommerceWeb.eCommerceWeb.entity.Category;
import com.eCommerceWeb.eCommerceWeb.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    CategoryRepository categoryRepository;
    public List<Category> getAllCategory(){
        return categoryRepository.findAll();
    }
    public void addCategory(Category category){
        categoryRepository.save(category);
    }
}
