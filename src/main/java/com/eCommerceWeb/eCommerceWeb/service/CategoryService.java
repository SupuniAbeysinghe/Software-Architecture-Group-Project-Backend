package com.eCommerceWeb.eCommerceWeb.service;

import com.eCommerceWeb.eCommerceWeb.entity.Category;
import com.eCommerceWeb.eCommerceWeb.entity.Product;
import com.eCommerceWeb.eCommerceWeb.repository.CategoryRepository;
import com.eCommerceWeb.eCommerceWeb.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    ProductRepository productRepository;
//    public List<Category> getAllCategory(){
//        return categoryRepository.findAll();
//    }
//    public void addCategory(Category category){
//        categoryRepository.save(category);
//    }
//    public void removeCategoryById(int id){
//        categoryRepository.deleteById(id);
//    }
//    public Optional<Category> getCategoryById(int id){
//        return categoryRepository.findById(id);
//
//    }


     public List<Product> getProductsByCategoryName(String catKey) {
         if(catKey.equals("")) {
             return (List<Product>) productRepository.findAll();

         }else{
             return productRepository.findByCategories_Name(
                     catKey
             );
         }
     }
}


