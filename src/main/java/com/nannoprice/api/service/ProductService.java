package com.nannoprice.api.service;

import com.nannoprice.api.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface ProductService extends MongoRepository<Product, String> {
    public List<Product> findAll();

    public Product getProductById(String id);
}