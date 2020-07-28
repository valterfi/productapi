package com.ciccc.productapiclient.entity;

import java.io.Serializable;
import java.util.List;

public class Data implements Serializable {
	
	private List<Product> products;

	public Data(List<Product> products) {
		this.products = products;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

}
