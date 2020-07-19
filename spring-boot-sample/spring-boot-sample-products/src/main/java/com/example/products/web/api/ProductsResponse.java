package com.example.products.web.api;

import java.util.List;

import com.example.products.model.Product;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductsResponse {
	
	private List<Product> products;

}
