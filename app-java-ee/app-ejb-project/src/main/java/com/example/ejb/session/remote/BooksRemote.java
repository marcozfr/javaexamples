package com.example.ejb.session.remote;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;
import javax.jws.soap.SOAPBinding.Style;
import javax.jws.soap.SOAPBinding.Use;

import com.example.ejb.exception.BusinessException;
import com.example.model.catalog.Book;

@WebService
@SOAPBinding(style=Style.DOCUMENT,use=Use.LITERAL,parameterStyle=ParameterStyle.BARE)
//@HandlerChain(file="handlers.xml")
public interface BooksRemote {
    
    @WebMethod(operationName="findById")
    @WebResult(name="book")
    Book findBookById(Long bookId);
    
    @WebMethod(operationName="findAll")
    @WebResult(name="books")
    List<Book> findAllBooks();
    
    @WebMethod(operationName="save")
    Book saveBook(Book book) throws BusinessException;
    
    @WebMethod(operationName="getCover")
    byte[] getBookCover(Long bookId);
    
    @WebMethod(operationName="saveCover")
    @SOAPBinding(parameterStyle=ParameterStyle.WRAPPED)
    boolean saveBookCover(Long bookId, byte[] cover);

}
