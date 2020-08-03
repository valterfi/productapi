package com.ciccc.productapi.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ciccc.productapi.data.ProductDatabase;
import com.ciccc.productapi.model.Product;

@Repository
public class ProductRepository {
	
	@Autowired
	private ProductDatabase productDatabase;
	
	public List<Product> listAll() {
        List<Product> products = new ArrayList<Product>();
        for (Integer id : productDatabase.getProductData().keySet()) {
        	products.add(productDatabase.getProductData().get(id));
        }
        return products;
    }
     
    public Product save(Product product) {
    	Integer id = product.getId();
    	if (id != null) {
    		productDatabase.getProductData().put(id, product);
    		return product;
    	} else {
    		Random random = new Random();
    		id = Math.abs(random.nextInt());
    		product.setId(id);
    		productDatabase.getProductData().put(id, product);
    		return product;
    	}
    }
     
    public Product get(Integer id) {
        return productDatabase.getProductData().get(id);
    }
     
    public void delete(Integer id) {
        productDatabase.getProductData().remove(id);
    }

}
