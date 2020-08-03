package com.ciccc.productapi.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.ciccc.productapi.model.Product;

@Repository
public interface ProductMongoRepository extends MongoRepository<Product, Integer>  {

}
