package com.example.ejb.session.local;

import java.util.List;

import javax.ejb.Local;

import com.example.model.catalog.Book;

@Local
public interface BooksLocal {
    
    Book saveBook(Book book);
    
    List<Book> findAllBooks();
    
}
