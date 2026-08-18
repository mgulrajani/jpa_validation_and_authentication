package com.neueda.dto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Min;
/* 
public class ProductRequest {

    @NotBlank(message = "Name is mandatory")
    private String name;

    @Min(value = 1, message = "Price must be greater than 0")
    private Double price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    // getters and setters


    
}*/


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Min;

public record ProductRequest(
    @NotBlank(message = "Name is required") String name,
    @Min(value = 1, message = "Price must be greater than 0") Double price
) {}


