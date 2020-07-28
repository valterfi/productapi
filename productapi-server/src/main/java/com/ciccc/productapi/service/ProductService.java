package com.ciccc.productapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ciccc.productapi.model.Product;
import com.ciccc.productapi.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	
	public List<Product> listAll() {
        return productRepository.listAll();
    }
     
    public void save(Product product) {
    	productRepository.save(product);
    }
     
    public Product get(Integer id) {
    	return productRepository.get(id);
    }
     
    public void delete(Integer id) {
    	productRepository.delete(id);
    }
	
	

}
