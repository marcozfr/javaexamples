package com.example.ejb.session.remote;

import javax.ejb.Remote;
import javax.jws.WebService;

import com.example.model.catalog.Book;

@Remote
@WebService
public interface BooksRemote {
    
    Book findBookById(Long bookId);

}