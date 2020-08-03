package com.ciccc.productapi.repository;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ciccc.productapi.model.Product;

@Repository
@Qualifier("productJPARepository")
public interface ProductJPARepository extends CrudRepository<Product, Integer> {

}
