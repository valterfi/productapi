package com.ciccc.productapiclient;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.ciccc.productapiclient.entity.Product;

@SpringBootApplication
public class ProductapiClientApplication {
	
	private static RestTemplate restTemplate = new RestTemplate();
	
	private static final String BASE_URL = "http://localhost:8080"; 

	public static void main(String[] args) {
		
		createProduct("product5", 55.5);
		
		getProducts();
		
	}
	
	private static void getProducts() {
		ResponseEntity<Product[]> response = restTemplate.getForEntity(BASE_URL + "/products", Product[].class);
		Product[] products = response.getBody();
		for (Product product : products) {
			System.out.println(product);
		}
	}
	
	private static Product getProduct(int id) {
		ResponseEntity<Product> response = restTemplate.getForEntity(BASE_URL + "/products/" + id, Product.class);
		Product product = response.getBody();
		System.out.println(product);
		return product;
	}
	
	private static Product createProduct(String name, Double price) {
		Product product = new Product();
		product.setName(name);
		product.setPrice(price);
		ResponseEntity<Product> response = restTemplate.postForEntity(BASE_URL + "/products/", product, Product.class);
		return response.getBody();
	}
	
	private static void updateProduct(Product product) {
		restTemplate.put(BASE_URL + "/products/" + product.getId(), product);
		
//		HttpHeaders headers = new HttpHeaders();
//	    headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
//	    HttpEntity<Product> entity = new HttpEntity<Product>(product, headers);
//		
//		ResponseEntity<Product> response = restTemplate.exchange(BASE_URL + "/products/" + product.getId(), HttpMethod.PUT, entity, Product.class);
	}
	
	private static void deleteProduct(int id) {
		restTemplate.delete(BASE_URL + "/products/" + id);
	}

}
