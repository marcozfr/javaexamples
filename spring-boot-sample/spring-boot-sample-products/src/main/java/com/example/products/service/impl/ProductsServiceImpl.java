package com.example.products.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.example.products.dao.ProductsMongoRepository;
import com.example.products.model.Product;
import com.example.products.model.ProductFilter;
import com.example.products.service.ProductsService;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

@Service
@Slf4j
public class ProductsServiceImpl implements ProductsService {
	
	@Autowired
	ProductsMongoRepository productsMongoRepository;

	@Override
	public Flux<Product> findProducts(ProductFilter productFilter) {
		Flux<Product> productsFlux = productsMongoRepository
				.findByFilters(
						productFilter.getDescriptionQuery(), 
						PageRequest.of(productFilter.getStart(), productFilter.getPageSize()));
		productsFlux.subscribeOn(Schedulers.elastic())
			.subscribe(p -> log.info("Returning product {}" , p.getShortDescription()));
		return productsFlux;
	}

	@Override
	public Mono<Product> saveProduct(Product product) {
		return productsMongoRepository.save(product);
	}

	@Override
	public Mono<Product> getProduct(String productId) {
		return productsMongoRepository.findById(productId);
	}

}
