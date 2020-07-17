package com.ciccc.productapi.data;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.ciccc.productapi.model.Product;

@Component
@Scope("singleton")
public class ProductDatabase {
	
	private Map<Integer, Product> productData = new HashMap<Integer, Product>();

	public Map<Integer, Product> getProductData() {
		return productData;
	}

	public void setProductData(Map<Integer, Product> productData) {
		this.productData = productData;
	}

}
