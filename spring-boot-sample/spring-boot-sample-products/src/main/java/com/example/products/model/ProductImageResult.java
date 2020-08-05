package com.example.products.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductImageResult {

    private String id;
    private String productId;
    private String url;

    public ProductImageResult(String id){
        this.id = id;
    };

}
