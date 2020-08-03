package com.ciccc.productapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ciccc.productapi.model.Product;
import com.ciccc.productapi.repository.ProductJPARepository;
import com.ciccc.productapi.repository.ProductRepository;

@Service
public class ProductService {
	
//	@Autowired
//	private ProductRepository productRepository;
	
	@Autowired
	private ProductJPARepository productRepository;
	
	public List<Product> listAll() {
        return (List<Product>) productRepository.findAll();
    }
     
    public void save(Product product) {
    	productRepository.save(product);
    }
     
    public Product get(Integer id) {
    	return productRepository.findById(id).get();
    }
     
    public void delete(Integer id) {
    	productRepository.deleteById(id);
    }
	
	

}
