package com.example.web.ws;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import com.example.web.model.AppBook;

@WebService
public interface CatalogWService {
    
    @WebMethod
    public List<AppBook> getBook(String id);
}
