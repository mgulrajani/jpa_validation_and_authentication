package com.neueda.services;

import java.util.List;

import com.neueda.dto.ProductRequest;
import com.neueda.entities.Product;

public interface ProductService {

    public List<Product> getAllProducts();
    public Product addProduct(ProductRequest request);

    
     
}
