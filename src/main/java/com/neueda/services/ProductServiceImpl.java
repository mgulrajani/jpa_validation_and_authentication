package com.neueda.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neueda.dto.ProductRequest;
import com.neueda.entities.Product;
import com.neueda.repos.ProductRepository;
@Service
public class ProductServiceImpl implements ProductService {

    //dependency of repository layer

     private  ProductRepository productRepository;

    //constructor injection
    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product addProduct(ProductRequest request) {

        Product product = new Product();
        product.setName(request.getName());
        product.setPrice(request.getPrice());
        
        return productRepository.save(product); 
    }

}
