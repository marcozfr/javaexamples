package com.example.web;

import java.util.Arrays;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import org.jboss.logging.Logger;

@WebService
public class ProductService {
    
    public static final Logger LOGGER = Logger.getLogger(ProductService.class);
    
    @WebMethod(operationName="products")
    public List<String> getProducts(){
        
        LOGGER.info("retrieving list of products");
        
        return Arrays.asList("iPhone","Huawei","Motorola");
    }
    
}
