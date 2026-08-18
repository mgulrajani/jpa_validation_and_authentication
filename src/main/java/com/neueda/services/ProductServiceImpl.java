package com.neueda.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.neueda.dto.ProductRequest;
import com.neueda.dto.ProductResponse;
import com.neueda.entities.Product;
import com.neueda.repos.ProductRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository repository;

    public ProductServiceImpl(ProductRepository repository) {
        this.repository = repository;
    }

    public List<ProductResponse> getAllProducts() {
        return repository.findAll()
                         .stream()
                         .map(p -> new ProductResponse(p.getId(), p.getName(), p.getPrice()))
                         .toList();
    }

    public ProductResponse saveProduct(ProductRequest request) {
        Product product = new Product();
        product.setName(request.name());
        product.setPrice(request.price());
        Product saved = repository.save(product);
        return new ProductResponse(saved.getId(), saved.getName(), saved.getPrice());
    }

    @Override
    public <Optional> ProductResponse getById(Long id) throws EntityNotFoundException {
        Product product = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Product not found with id: " + id));
        return new ProductResponse(product.getId(), product.getName(), product.getPrice());
    }


    @Override
    public ProductResponse updateProduct(Long id, ProductRequest request) throws EntityNotFoundException {
        Product product = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Product not found with id: " + id));
        product.setName(request.name());
        product.setPrice(request.price());
        Product updated = repository.save(product);
        return new ProductResponse(updated.getId(), updated.getName(), updated.getPrice());     



    
}

    @Override
    public void deleteProduct(Long id) throws EntityNotFoundException {
        Product product = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Product not found with id: " + id));
        repository.delete(product);
    }           


    @Override
    public ProductResponse updateProductForPatch(Long id, ProductRequest request) throws EntityNotFoundException {
        Product product = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Product not found with id: " + id));
        if (request.name() != null) {
            product.setName(request.name());
        }
        if (request.price() != null) {
            product.setPrice(request.price());
        }
        Product updated = repository.save(product);
        return new ProductResponse(updated.getId(), updated.getName(), updated.getPrice());                 }
        



}
