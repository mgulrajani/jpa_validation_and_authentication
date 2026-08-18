package com.neueda.services;

import java.util.List;

import com.neueda.dto.ProductRequest;
import com.neueda.dto.ProductResponse;

import jakarta.persistence.EntityNotFoundException;

public interface ProductService {

    public List<ProductResponse> getAllProducts();
    public ProductResponse saveProduct(ProductRequest request);
    public <Optional>ProductResponse getById(Long id) throws EntityNotFoundException;
    public ProductResponse updateProduct(Long id, ProductRequest request) throws EntityNotFoundException;
    public void deleteProduct(Long id) throws EntityNotFoundException;
    ProductResponse updateProductForPatch(Long id, ProductRequest request) throws EntityNotFoundException;    
   
    
     
}
