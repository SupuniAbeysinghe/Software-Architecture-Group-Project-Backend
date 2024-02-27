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
}
