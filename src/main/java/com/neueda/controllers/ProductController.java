package com.neueda.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neueda.dto.ProductRequest;
import com.neueda.dto.ProductResponse;
import com.neueda.entities.Product;
import com.neueda.services.ProductService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;




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
    public List<ProductResponse> getAllProducts() {
        return productService.getAllProducts(); 
  
    }

    @GetMapping("/{id}")
    public ProductResponse getProductById(@RequestParam Long id) throws Exception {
        return productService.getById(id);
    }
    
  //want to add a new product
    @PostMapping 
    public ProductResponse addProduct(@Valid @RequestBody ProductRequest request) {
        return productService.saveProduct(request);
    }   

    @PutMapping("/{id}")
    public ProductResponse updateProduct(@PathVariable Long id, @Valid @RequestBody ProductRequest request) throws Exception {
        return productService.updateProduct(id, request);
    }   

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id) throws Exception {
        productService.deleteProduct(id);
    }

    @PatchMapping("/{id}")
    public ProductResponse updateProductForPatch(@PathVariable Long id, @RequestBody ProductRequest request) throws Exception {
        return productService.updateProductForPatch(id, request);}
        


}
