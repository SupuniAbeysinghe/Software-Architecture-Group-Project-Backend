package com.eCommerceWeb.eCommerceWeb.controller;

import com.eCommerceWeb.eCommerceWeb.entity.Category;
import com.eCommerceWeb.eCommerceWeb.entity.Product;
import com.eCommerceWeb.eCommerceWeb.entity.User;
import com.eCommerceWeb.eCommerceWeb.repository.CategoryRepository;
import com.eCommerceWeb.eCommerceWeb.repository.UserRepository;
import com.eCommerceWeb.eCommerceWeb.service.CategoryService;
import com.eCommerceWeb.eCommerceWeb.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/admin/products")
public class AdminController {
    @Autowired
    CategoryService categoryService;
    @GetMapping("/admin")
    public String adminHome(){
        return "adminHome";
    }

    CategoryRepository categoryRepository;
    @Autowired
    public AdminController(CategoryRepository categoryRepository){
        this.categoryRepository=categoryRepository;
    }
    @GetMapping("/categories")
    public Category getCategory(@RequestParam int id){
        return categoryRepository.findById(id);
    }

//    @GetMapping("/admin/categories/add")
//    public String getCatAdd(Model model){
//        model.addAttribute("category",new Category());
//        return "categoriesAdd";
//    }

    @PostMapping("/categories/add")
    public void addCategory(@RequestBody Category category){
        categoryRepository.save(category);
    }

//    @GetMapping("/admin/categories/delete/{id}")
//    public String deleteCat(@PathVariable int id){
//        categoryService.removeCategoryById(id);
//        return "redirect:/admin/categories";
//    }
//
//    @GetMapping("/admin/categories/update/{id}")
//    public String updateCat(@PathVariable int id, Model model){
//        Optional<Category> category = categoryService.getCategoryById(id);
//        if(category.isPresent()){
//            model.addAttribute("category",category.get());
//            return "Category added";
//        }else {
//            return "Category not added";
//        }
//    }
    //for update product details
    @Autowired
    private ProductService productService;

    @PutMapping("/{productId}")
    public ResponseEntity<String> updateProduct(@PathVariable int productId, @RequestBody Product product) {
        boolean isUpdated = productService.updateProduct(productId, product);
        if (isUpdated) {
            return new ResponseEntity<>("Product updated successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Failed to update product", HttpStatus.NOT_FOUND);
        }
    }

    // Delete a product
    @DeleteMapping("/{productId}")
    public ResponseEntity<String> deleteProduct(@PathVariable int productId) {
        boolean isDeleted = productService.deleteProduct(productId);
        if (isDeleted) {
            return new ResponseEntity<>("Product deleted successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Failed to delete product", HttpStatus.NOT_FOUND);
        }
    }
}


