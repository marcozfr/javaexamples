package com.example.products.model;

import lombok.Data;

@Data
public class ProductFilter {
	
	private String descriptionQuery;
	private Integer pageSize;
	private Integer start;

}
