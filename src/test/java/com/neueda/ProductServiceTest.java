
package com.neueda;

import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.exceptions.base.MockitoException;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import com.neueda.dto.ProductResponse;
import com.neueda.entities.Product;
import com.neueda.repos.ProductRepository;
import com.neueda.services.ProductService;
import com.neueda.services.ProductServiceImpl;

import jakarta.inject.Inject;
import jakarta.persistence.EntityNotFoundException;

@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {
 //Arrange Act Assert pattern 
    @Mock
   private ProductRepository mockProductRepository;
   @InjectMocks
    private ProductServiceImpl productServiceImpl;

    //setting up the test environment
    //using @MockBean to mock the repository and test the service layer
    //set up mock data for the repository
    List<Product> mockProducts = List.of(
        new Product(4L, "Product 4", 10.0),
        new Product(5L, "Product 5", 20.0),
        new Product(6L, "Product 6", 30.0)
    );  
    
    //test the getAllProducts method of the ProductServiceImpl class
    @Test
    //to mock the repository and test the service layer
    public void testGetAllProducts() {
        when(mockProductRepository.findAll()).thenReturn(mockProducts);
        productServiceImpl = new ProductServiceImpl(mockProductRepository);
        List<ProductResponse> products = productServiceImpl.getAllProducts();
        assert(products.size() == 3);   

    }
   @Test
    public void testGetById() throws EntityNotFoundException     {
        when(mockProductRepository.findById(5L)).thenReturn(java.util.Optional.of(mockProducts.get(1)));
        productServiceImpl = new ProductServiceImpl(mockProductRepository);
        ProductResponse product = productServiceImpl.getById(5L);
        assert(product.id() == 5L);


    
}
}
