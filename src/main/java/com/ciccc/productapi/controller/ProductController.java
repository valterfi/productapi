package com.ciccc.productapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ciccc.productapi.model.Product;
import com.ciccc.productapi.service.ProductService;

@RestController
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@GetMapping("/products")
	public List<Product> list() {
		return productService.listAll();
	}
	
	@GetMapping("/products/{id}")
	public ResponseEntity<Product> get(@PathVariable Integer id) {
		Product product = productService.get(id);
		if (product !=  null) {
			return new ResponseEntity<Product>(product, HttpStatus.OK);
		} else {
			return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/products")
	public ResponseEntity<Product> add(@RequestBody Product product) {
		if (product.getId() == null) {
			productService.save(product);
			return new ResponseEntity<Product>(product, HttpStatus.CREATED);
		} else {
			return new ResponseEntity<Product>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/products/{id}")
	public ResponseEntity<Product> update(@RequestBody Product product, @PathVariable Integer id) {
		Product existProduct = productService.get(id);
		if (existProduct != null) {
			existProduct.setName(product.getName());
			existProduct.setPrice(product.getPrice());
			productService.save(existProduct);
			return new ResponseEntity<Product>(HttpStatus.OK);
		} else { 
			return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/products/{id}")
	public void delete(@PathVariable Integer id) {
		productService.delete(id);
	}

}
