package com.example.products.dao;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.reactive.ReactiveSortingRepository;

import com.example.products.model.Product;

import reactor.core.publisher.Flux;

public interface ProductsMongoRepository extends ReactiveSortingRepository<Product, String>{

	@Query("{ 'shortDescription': ?0}")
	Flux<Product> findByFilters(String description, PageRequest pageRequest);

}
