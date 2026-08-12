package com.neueda.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public Product addProduct(Product product) {
        return productRepository.save(product); 
    }

}
