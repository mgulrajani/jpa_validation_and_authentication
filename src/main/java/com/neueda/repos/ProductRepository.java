package com.neueda.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.neueda.entities.Product;
@Repository
public interface ProductRepository 
    extends JpaRepository<Product,Long>{
        //jpql
        //native query
        //select p from Product p where p.name = ?1

}
