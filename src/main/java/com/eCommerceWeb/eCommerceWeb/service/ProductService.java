package com.eCommerceWeb.eCommerceWeb.service;

import com.eCommerceWeb.eCommerceWeb.entity.Product;
import com.eCommerceWeb.eCommerceWeb.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;

    public List<Product> getAllProducts(String searchKey){


        if(searchKey.equals("")) {
            return (List<Product>) productRepository.findAll();

        }else{
            return productRepository.findByProductNameOrDescriptionContainingIgnoreCase(
                    searchKey,searchKey
            );
        }
    }

    //update products
    public boolean updateProduct(int productId, Product updatedProduct) {
        // Check if the product with the given ID exists
        Product existingProduct = productRepository.findById(productId);
        if (existingProduct == null) {
            return false; // Product not found, cannot update
        }

        // Update the fields of the existing product with the new values
        existingProduct.setProduct_name(updatedProduct.getProduct_name());
        existingProduct.setProduct_category(updatedProduct.getProduct_category());
        existingProduct.setPrice(updatedProduct.getPrice());
        existingProduct.setDescription(updatedProduct.getDescription());
        existingProduct.setCreatedAt(updatedProduct.getCreatedAt());
        existingProduct.setImageFileName(updatedProduct.getImageFileName());

        // Save the updated product
        productRepository.save(existingProduct);

        return true; // Product updated successfully
    }
}
