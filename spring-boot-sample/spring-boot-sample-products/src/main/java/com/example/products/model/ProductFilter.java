package com.example.products.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductFilter {
	
	private String descriptionQuery;
	private Integer pageSize;
	private Integer start;

}
