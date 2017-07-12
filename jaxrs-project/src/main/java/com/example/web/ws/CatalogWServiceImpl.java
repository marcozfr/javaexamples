package com.example.web.ws;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;
import javax.jws.soap.SOAPBinding.Style;
import javax.jws.soap.SOAPBinding.Use;

import com.example.web.model.AppBook;
import com.example.web.repository.CatalogRepository;

@WebService
@SOAPBinding(style=Style.DOCUMENT,use=Use.LITERAL,parameterStyle=ParameterStyle.WRAPPED)
public class CatalogWServiceImpl implements CatalogWService {

    @Override
    @WebMethod
    public List<AppBook> getBook(String id) {
        // TODO Auto-generated method stub
        return CatalogRepository.getAppCatalog().getBooks();
    }

}
