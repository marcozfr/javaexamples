package com.example.products.service;

import com.example.products.model.Product;
import com.example.products.model.ProductFilter;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ProductsService {
	
	Flux<Product> findProducts(ProductFilter productFilter);

	Mono<Product> saveProduct(Product product);

	Mono<Product> getProduct(String productId);

}
