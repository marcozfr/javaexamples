package com.example.products.service;

import com.example.products.model.Product;
import com.example.products.model.ProductFilter;

import com.example.products.model.ProductImageResult;
import org.springframework.http.codec.multipart.FilePart;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ProductsService {
	
	Flux<Product> findProducts(ProductFilter productFilter);

	Mono<Product> saveProduct(Product product);

	Mono<Product> getProduct(String productId);

	Flux<ProductImageResult> saveProductImages(Flux<FilePart> productImages);

}
