package com.example.ejb.session.remote;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;
import javax.jws.soap.SOAPBinding.Style;
import javax.jws.soap.SOAPBinding.Use;

import com.example.model.catalog.Book;

@WebService
@SOAPBinding(style=Style.DOCUMENT,use=Use.LITERAL,parameterStyle=ParameterStyle.BARE)
public interface BooksRemote {
    
    @WebMethod(operationName="findById")
    @WebResult(name="book",partName="bookPart")
    Book findBookById(Long bookId);
    
    @WebMethod(operationName="findAll")
    @WebResult(name="books",partName="booksPart")
    List<Book> findAllBooks();

}
