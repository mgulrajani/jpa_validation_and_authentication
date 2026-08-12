package com.neueda.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neueda.entities.Product;
import com.neueda.services.ProductService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/products")    
public class ProductController {
//dependency of service layer
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }
  
    //get all products
    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts(); 
  
    }
  //want to add a new product
    @PostMapping 
    public Product addProduct(@RequestBody Product product) {
        return productService.addProduct(product);
    }   


}
