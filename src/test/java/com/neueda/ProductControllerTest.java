package com.neueda;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import com.neueda.controllers.ProductController;
import com.neueda.dto.ProductResponse;
import com.neueda.services.ProductService;

@WebMvcTest(controllers = ProductController.class)
public class ProductControllerTest {
     @Autowired
    private MockMvc mockMvc;
    @MockitoBean
    private ProductService productService;
   

    
    @Test
    public void testGetAllProducts() throws Exception {
        when(productService.getAllProducts()).thenReturn(List.of(
            new ProductResponse(1L, "Product 1", 10.0),
            new ProductResponse(2L, "Product 2", 20.0),
            new ProductResponse(3L, "Product 3", 30.0)
        )); 
        mockMvc.perform(get("/api/products"))
               .andExpect(status().isOk())
               .andExpect(content().contentType(MediaType.APPLICATION_JSON))
               .andExpect(jsonPath("$", hasSize(3)))
               .andExpect(jsonPath("$[0].id").value(1))
               .andExpect(jsonPath("$[0].name").value("Product 1"))
               .andExpect(jsonPath("$[0].price").value(10.0));
    }   
    

}
