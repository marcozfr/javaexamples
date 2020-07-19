package com.example.products.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.hateoas.RepresentationModel;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product extends RepresentationModel<Product>{
	
	@Id
	private String id;
	private String shortDescription;
	private String longDescription;
	private String sku;
	private String model;
	private String price;
	private Currency currency;
	private List<String> tags;
	private String availability;
	private List<ProductSpecs> specs;

}
