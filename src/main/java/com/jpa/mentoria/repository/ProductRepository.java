package com.jpa.mentoria.repository;

import com.jpa.mentoria.entity.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductRepository extends CrudRepository<Product, Long> {

        List<Product> findByName(String lastName);

        List<Product> findByPrice(double price);

        Product findById(long id);

        @Query(value = "from products p where p.price > 500")
        List<Product> findPriceBiggerThan500();

        @Query(value = "from products p where p.price > ?1")
        List<Product> findPriceBiggerThan(double price);

        @Query(value = "from products p where p.price < :price")
        List<Product> findPriceLessThan(double price);

 }
