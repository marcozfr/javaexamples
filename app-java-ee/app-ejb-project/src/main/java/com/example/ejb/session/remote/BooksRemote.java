package com.example.ejb.session.remote;

import java.util.List;

import javax.jws.WebService;

import com.example.model.catalog.Book;

@WebService
public interface BooksRemote {
    
    Book findBookById(Long bookId);
    
    List<Book> findAllBooks();

}
