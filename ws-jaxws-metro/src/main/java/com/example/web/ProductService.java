package com.example.web;

import java.util.Arrays;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public class ProductService {
    
    @WebMethod(operationName="products")
    public List<String> getProducts(){
        return Arrays.asList("iPhone","Huawei","Motorola");
    }
    
}
