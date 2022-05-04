package com.jpa.mentoria.repository;

import com.jpa.mentoria.entity.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductRepository extends CrudRepository<Product, Long> {


        List<Product> findByName(String lastName);

        List<Product> findByPrice(double price);

        Product findById(long id);
 }
