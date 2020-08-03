package com.ciccc.productapi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ciccc.productapi.model.Product;

@Repository
public interface ProductJPARepository extends CrudRepository<Product, Integer> {

}
