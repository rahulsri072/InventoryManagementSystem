package com.company.product.model;

public class RestockingResult {
	private Products product;

	public Products getProduct() {
		return product; 
	}
	public RestockingResult(Products product1){
		this.product = product1;
	}
}
